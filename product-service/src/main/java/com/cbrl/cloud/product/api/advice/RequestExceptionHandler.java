package com.cbrl.cloud.product.api.advice;

import com.cbrl.cloud.product.api.response.ApiError;
import com.cbrl.cloud.product.api.response.ApiResponse;
import com.cbrl.cloud.product.api.response.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * see all error ResponseEntityExceptionHandler
 */

@RestControllerAdvice
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RequestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors().stream()
                .map(err -> FieldError.builder().
                        rejectedValue(err.getRejectedValue())
                        .field(err.getField())
                        .message(err.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());

        ApiError apiError = ApiError.builder().message("Invalid request").code("000").fieldErrors(fieldErrors).build();
        return ApiResponse.fail(apiError);
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class, MissingPathVariableException.class})
    public ApiResponse handleMethodArgumentNotValid(Exception exception) {
        ApiError apiError = ApiError.builder().message(exception.getMessage()).code("000").build();
        return ApiResponse.fail(apiError);
    }
}
