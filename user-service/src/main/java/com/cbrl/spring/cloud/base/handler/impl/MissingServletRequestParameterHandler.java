package com.cbrl.spring.cloud.base.handler.impl;

import com.cbrl.spring.cloud.base.config.ErrorMessageLocator;
import com.cbrl.spring.cloud.base.handler.Handler;
import com.cbrl.spring.cloud.base.response.ApiError;
import com.cbrl.spring.cloud.base.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
public class MissingServletRequestParameterHandler implements Handler<MissingServletRequestParameterException> {
    private static final String ERROR_KEY = "validation.fail";

    private final ErrorMessageLocator errorMessageLocator;

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @Override
    public ApiResponse handleException(MissingServletRequestParameterException exception) {
        ApiError apiError = errorMessageLocator.error(ERROR_KEY, exception.getMessage());
        return ApiResponse.error(HttpStatus.BAD_REQUEST, apiError);
    }
}
