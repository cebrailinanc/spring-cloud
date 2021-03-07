package com.cbrl.cloud.product.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class CheckStockDto extends BaseDto {

    private Boolean existStock;
}
