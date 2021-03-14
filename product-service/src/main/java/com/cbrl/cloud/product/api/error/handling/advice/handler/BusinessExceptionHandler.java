package com.cbrl.cloud.product.api.error.handling.advice.handler;

import com.cbrl.cloud.product.api.error.handling.advice.configuration.ErrorDto;
import com.cbrl.cloud.product.api.error.handling.advice.configuration.ErrorMessageLocator;
import com.cbrl.cloud.product.api.error.handling.advice.exception.BusinessException;
import com.cbrl.cloud.product.api.error.handling.advice.response.ApiError;
import com.cbrl.cloud.product.api.error.handling.advice.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BusinessExceptionHandler {

    private final ErrorMessageLocator errorMessageLocator;

    @ExceptionHandler(BusinessException.class)
    public ApiResponse handleBusinessException(BusinessException exception) {

        ErrorDto error = errorMessageLocator.error(exception.getErrorKey(),exception.getArgs());
        ApiError apiError = ApiError.builder().code(error.getCode()).message(error.getMessage()).build();
        return ApiResponse.error(apiError);
    }

}
