package com.hdfc.auditingutils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Map;

class ExceptionHandlerAuditingSupportTest {


    @Test
    void should_test_method_argument_not_valid_exception() {
        AuditingAspect aspect = new AuditingAspect();
        StubEventPublisher eventPublisher = new StubEventPublisher();
        aspect.eventPublisher = eventPublisher;
        aspect.handleMethodArgumentNotValidException(
                null,
                new StubException(null, new MapBindingResult(Map.of(), ""))
        );

        Assertions.assertThat(eventPublisher.getEvents()).hasSize(1);
    }
}

class StubException extends MethodArgumentNotValidException {

    public StubException(MethodParameter parameter, BindingResult bindingResult) {
        super(parameter, bindingResult);
    }


}