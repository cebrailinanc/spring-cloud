package com.cbrl.cloud.product.api.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse {

    private ApiResponse(Status status) {
        timestamp = LocalDateTime.now();
        this.status = status;
    }

    private ApiResponse(Status status, ApiError error) {
        timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
    }

    private ApiResponse (Status status, Object data) {
        timestamp = LocalDateTime.now();
        this.status = status;
        this.data = data;
    }

    private LocalDateTime timestamp;
    private Status status;
    private Object data;
    private ApiError error;

    public enum Status {
        SUCCESS, // success request
        FAIL,    // Invalid request
        ERROR    // ınternel server error
    }

    public static ApiResponse success() {
        return new ApiResponse(Status.SUCCESS);
    }

    public static ApiResponse success(Object data) {
        return new ApiResponse(Status.SUCCESS, data);
    }

    public static ApiResponse fail(ApiError error) {
        return new ApiResponse(Status.FAIL, error);
    }

    public static ApiResponse error(ApiError error) {
        return new ApiResponse(Status.ERROR, error);
    }
}
