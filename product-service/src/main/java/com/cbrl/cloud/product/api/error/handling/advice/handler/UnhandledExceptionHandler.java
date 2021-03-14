package com.cbrl.cloud.product.api.error.handling.advice.handler;

import com.cbrl.cloud.product.api.error.handling.advice.response.ApiError;
import com.cbrl.cloud.product.api.error.handling.advice.response.ApiResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class UnhandledExceptionHandler {

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApiResponse handleUnhandledExceptionHandle(Exception exception) {
        log.error("UnhandledException: {} ", exception);
        ApiError apiError = ApiError.builder().message(exception.getMessage()).code("-1").build();
        return ApiResponse.error(apiError);
    }
}
