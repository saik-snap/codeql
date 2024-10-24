package com.hdfc.events.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.util.Map;
@Setter
@AllArgsConstructor
@Data
public class AuditData {

    private HttpRequestData request;
    private CustomerData customer;
    private Map<String, Object> extraDat;

    @Builder
    public AuditData() {

    }
    public HttpRequestData request() {
        return this.request == null
                ? HttpRequestData.empty()
                : this.request;
    }

}
