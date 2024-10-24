package com.hdfc.rest.commons;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Set;

public final class ApiResponse<T> {

    private ErrorResponse error;
    private T data;
    private Status status;

    @JsonCreator
    public ApiResponse(@JsonProperty("status") Status status,
                       @JsonProperty("data") T data,
                       @JsonProperty("error") ErrorResponse error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(Status.SUCCESS, data, null);
    }

    public static <T> ApiResponse<T> accepted(T data) {
        return new ApiResponse<>(Status.ACCEPTED, data, null);
    }

    public static <T> ApiResponse<T> error(ErrorResponse error) {
        return new ApiResponse<>(Status.ERROR, null, error);
    }

    public static ApiResponse<Void> success() {
        return new ApiResponse<>(Status.SUCCESS, null, null);
    }

    public static <T> ApiResponse<T> notModified() {
        return new ApiResponse<T>(Status.NOT_MODIFIED, null, null);
    }

    public enum Status {
        ACCEPTED("accepted"), SUCCESS("success"), ERROR("error"), NOT_MODIFIED("notModified");

        private final String status;

        Status(String status) {
            this.status = status;
        }

        @JsonValue
        public String getStatus() {
            return this.status;
        }
    }

    public ErrorResponse getError() {
        return this.error;
    }

    public T getData() {
        return this.data;
    }

    public Status getStatus() {
        return this.status;
    }

    public boolean isSuccessfulResponse() {
        Set<Status> successFulStatus = Set.of(Status.SUCCESS, Status.NOT_MODIFIED, Status.ACCEPTED);
        return successFulStatus.contains(this.getStatus());
    }
}
