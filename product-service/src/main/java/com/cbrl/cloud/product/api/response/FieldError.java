package com.cbrl.cloud.product.api.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FieldError {
    private String field;
    private Object rejectedValue;
    private String message;
}
