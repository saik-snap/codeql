package com.hdfc.accounts.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public record AccountEntityRequest(
        @NotBlank String title,
        @JsonProperty("is_active") boolean isActive) {
}