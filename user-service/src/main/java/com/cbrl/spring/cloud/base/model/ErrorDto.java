package com.cbrl.spring.cloud.base.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDto {
    private String code;
    private String message;
}
