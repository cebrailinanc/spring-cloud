package com.cbrl.cloud.product.service.impl;

import com.cbrl.cloud.product.api.error.handling.advice.exception.BusinessException;
import com.cbrl.cloud.product.data.model.Stock;
import com.cbrl.cloud.product.data.repository.StockRepository;
import com.cbrl.cloud.product.dto.CheckStockDto;
import com.cbrl.cloud.product.dto.StockDto;
import com.cbrl.cloud.product.dto.mapper.StockMapper;
import com.cbrl.cloud.product.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StockServiceImpl implements StockService {

    private final StockRepository repository;
    private final StockMapper stockMapper;

    @Override
    public CheckStockDto checkStock(Long productId, Long count) {
        Optional<Stock> stock = repository.findByProductId(productId);
        boolean existStock = false;
        if (stock.isPresent()) {
            existStock = stock.get().getCount().compareTo(count) > -1;
        }
        return CheckStockDto.builder().existStock(existStock).build();
    }

    @Override
    public void createStock(StockDto dto) {
        Optional<Stock> entity = repository.findByProductId(dto.getProductId());
        entity.ifPresent(stock -> {
            throw new BusinessException("stock.product-exist", stock.getProductId());
        });
        repository.save(stockMapper.toStock(dto));
    }

    @Override
    public void addStock(StockDto dto) {
        Optional<Stock> entity = repository.findByProductId(dto.getProductId());
        entity.orElseThrow(() -> new BusinessException("stock.product-not-found", dto.getProductId()));
        repository.addStock(dto.getCount(), dto.getProductId());
    }
}
