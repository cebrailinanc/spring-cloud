package com.cbrl.cloud.product.api.error.handling.advice.configuration;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDto {
    private String code;
    private String message;
}
