package com.mybank.daprtestservice.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public record MyEntityRequest(
        @NotBlank String title,
        @JsonProperty("is_active") boolean isActive) {
}