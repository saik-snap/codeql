package com.hdfc.events.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HttpRequestData {

    private String requestId;
    private String clientIpAddress;
    private String requestUri;
    private Object request;
    private Object response;
    private String errorMessage;
    public HttpRequestData(String requestId, String clientIpAddress, String requestUri, Object request, Object response) {
        this(requestId, clientIpAddress, requestUri, request, response, null);
    }

    public static HttpRequestData empty() {
        return new HttpRequestData(null, null, null, null, null, null);
    }
}
