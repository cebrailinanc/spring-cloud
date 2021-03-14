package com.cbrl.cloud.product.api.error.handling.advice.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private Status status;
    private Object data;
    private ApiError error;

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
