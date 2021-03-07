package com.cbrl.cloud.product.service;

import com.cbrl.cloud.product.dto.CheckStockDto;
import com.cbrl.cloud.product.dto.StockDto;

public interface StockService {
    CheckStockDto checkStock(Long productId, Long count);

    void createStock(StockDto dto);
}
