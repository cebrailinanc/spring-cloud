package com.cbrl.cloud.product.api.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class StockRequest {

    @NotNull
    @Min(1)
    private Long productId;

    @NotNull
    @Min(1)
    private Long count;
}
