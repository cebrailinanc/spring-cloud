package com.cbrl.cloud.product.api.error.handling.advice.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
public class ApiError {

    private String code;
    private String message;
    private List<FieldError> fieldErrors;
}
