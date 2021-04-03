package com.cbrl.spring.cloud.base.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Data
public class ApiResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private boolean success;
    private int status;
    private Object data;
    private ApiError error;

    /**
     * constructor success response
     */
    private ApiResponse() {
        timestamp = LocalDateTime.now();
        this.status = HttpStatus.OK.value();
        this.success = true;
    }

    /**
     * constructor error response
     * @param httpStatus
     * @param error
     */
    private ApiResponse(HttpStatus httpStatus, ApiError error) {
        timestamp = LocalDateTime.now();
        this.status = httpStatus.value();
        this.error = error;
    }

    public static ApiResponse success() {
        return new ApiResponse();
    }

    public static ApiResponse success(Object data) {
        ApiResponse apiResponse = success();
        apiResponse.setData(data);
        return apiResponse;
    }

    public static ApiResponse error(HttpStatus httpStatus, ApiError error) {
        return new ApiResponse(httpStatus, error);
    }
}
