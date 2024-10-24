package com.hdfc.events.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerData {
    private String customerId;
    private String deviceId;
    private String device;
    private String mobileNo;
    private String persona;
    public CustomerData(String customerId) {
        this(customerId, null, null, null, null);
    }

}