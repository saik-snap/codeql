package com.mybank.registration.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public record RegistrationEntityRequest(
        @NotBlank String title,
        @JsonProperty("is_active") boolean isActive) {
}