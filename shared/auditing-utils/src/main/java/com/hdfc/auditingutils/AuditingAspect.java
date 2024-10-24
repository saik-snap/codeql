package com.hdfc.auditingutils;

import com.hdfc.events.Event;
import com.hdfc.events.data.AuditData;
import com.hdfc.events.data.CustomerData;
import com.hdfc.events.data.HttpRequestData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@Aspect
@Slf4j(topic = "audit-logs")
@RequiredArgsConstructor
@ConditionalOnProperty(name = "auditing.aspect.enabled", havingValue = "true", matchIfMissing = true)
public class AuditingAspect extends ExceptionHandlerAuditingSupport {

    @Value("${auditing.aspect.logging.enabled:false}")
    private boolean enableAuditingAspectLogging;

    @Around("(execution(* com.hdfc.*.controller.*.*(..)) && @annotation(postMapping))")
    public Object auditPostEndpoints(ProceedingJoinPoint proceedingJoinPoint, PostMapping postMapping) throws Throwable {
        Object[] requestArgs = proceedingJoinPoint.getArgs();
        String methodName = proceedingJoinPoint.getSignature().toShortString();
        Event.EventBuilder eventBuilder = Event.builder();
        AuditData.AuditDataBuilder auditDataBuilder = AuditData.builder();
        eventBuilder.type("com.auditing.http_request")
                .source(serviceName);
        String requestUri = MDC.get("requestUri");
        String clientIpAddress = MDC.get("clientIpAddress");
        String requestId = MDC.get("correlationId");
        CustomerData customer = getCustomerData();
        auditDataBuilder.build().setCustomer(customer);
        Object requestBody = requestArgs.length == 0 ? null : requestArgs[0];
        if (enableAuditingAspectLogging) {
            String requestJson = "";
            try {
                requestJson = requestBody != null ? objectMapper.writeValueAsString(requestBody) : "";
            } catch (Exception e) {
                log.warn("Cannot parse request body={}", requestBody);
            }
            log.info("Request for endpoint {} controller method {} is {}",
                    requestUri,
                    methodName,
                    requestJson);
        }

        try {
            var response = proceedingJoinPoint.proceed();
            auditDataBuilder.build().setRequest(new HttpRequestData(requestId, clientIpAddress, requestUri, requestBody,
                    response));

            if (enableAuditingAspectLogging) {
                String responseJson = objectMapper.writeValueAsString(response);
                log.info("Response for endpoint {} and controller method {} is {}",
                        requestUri,
                        methodName,
                        responseJson);
            }
            eventBuilder.data(auditDataBuilder.build());
            return response;
        } catch (Exception e) {
            var message = e.getMessage();
            log.error("Exception while executing the method {}."
                            + " Exception message is {}",
                    methodName, message, e);
            auditDataBuilder.build().setRequest(new HttpRequestData(requestId, clientIpAddress,
                    requestUri, requestBody, null, message));
            eventBuilder.data(auditDataBuilder.build());
            throw e;
        } finally {
            writeEvent(eventBuilder.build());
        }
    }


}
