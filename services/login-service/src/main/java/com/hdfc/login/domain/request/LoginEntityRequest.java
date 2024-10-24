package com.hdfc.login.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginEntityRequest {
    @NotBlank
    private String title;
    @JsonProperty("is_active")
    private boolean isActive;
    @JsonProperty("pin")
    private String pin;
}