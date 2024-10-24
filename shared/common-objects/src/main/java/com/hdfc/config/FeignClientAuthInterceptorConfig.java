package com.hdfc.config;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Objects;

@Slf4j
public class FeignClientAuthInterceptorConfig {

    private static final String AUTHORIZATION = "Authorization";

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (Objects.isNull(requestAttributes)) {
                log.error("User is not authenticated");
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User is not authenticated");
            }
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            requestTemplate.header(AUTHORIZATION, request.getHeader(AUTHORIZATION));
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String originalHeader = headerNames.nextElement();
                String cleanedHeader = originalHeader.toLowerCase().trim();
                if (cleanedHeader.startsWith("x-")) {
                    requestTemplate.header(originalHeader, request.getHeader(originalHeader));
                }
            }
        };
    }
}
