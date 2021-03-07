package com.cbrl.cloud.product.dto.mapper;

import com.cbrl.cloud.product.api.request.StockRequest;
import com.cbrl.cloud.product.data.model.Stock;
import com.cbrl.cloud.product.dto.StockDto;
import org.mapstruct.Mapper;

@Mapper
public interface StockMapper {

    StockDto toStockDto(StockRequest request);

    Stock toStock(StockDto dto);
}
