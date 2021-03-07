package com.cbrl.cloud.product.service.impl;

import com.cbrl.cloud.product.data.repository.StockRepository;
import com.cbrl.cloud.product.dto.CheckStockDto;
import com.cbrl.cloud.product.dto.StockDto;
import com.cbrl.cloud.product.dto.mapper.StockMapper;
import com.cbrl.cloud.product.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StockServiceImpl implements StockService {

    private final StockRepository repository;
    private final StockMapper stockMapper;

    @Override
    public CheckStockDto checkStock(Long productId, Long count) {
        return CheckStockDto.builder().existStock(false).build();
    }

    @Override
    public void createStock(StockDto dto) {
        repository.save(stockMapper.toStock(dto));
    }
}
