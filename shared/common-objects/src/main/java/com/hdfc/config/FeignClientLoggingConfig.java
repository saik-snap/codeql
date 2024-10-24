package com.hdfc.config;

import feign.Logger;
import feign.Request;
import feign.Response;
import feign.Util;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class FeignClientLoggingConfig extends Logger {

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        byte[] body = request.body() == null ? "".getBytes() : request.body();
        log.info("Through Feign-Logger, Request url : " + request.url()
                + ", Request Headers : " + request.headers()
                + ", Request Body : " + new String(body)
        );
    }

    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime)
            throws IOException {
        byte[] bodyData = response.body() == null ? "".getBytes() : Util.toByteArray(response.body().asInputStream());
        log.info("Through Feign-Logger, Response Headers : " + response.headers()
                + ", Response Body : " +  new String(bodyData)
                + ", Duration in millis : " + elapsedTime
        );
        return response.toBuilder().body(bodyData).build();
    }

    @Override
    protected void log(String configKey, String format, Object... args) {
        log.debug(format(configKey, format, args));
    }

    protected String format(String configKey, String format, Object... args) {
        return String.format(methodTag(configKey) + format, args);
    }
}

