package com.cbrl.cloud.product.api.controller;

import com.cbrl.cloud.product.api.request.StockRequest;
import com.cbrl.cloud.product.api.response.ApiResponse;
import com.cbrl.cloud.product.dto.CheckStockDto;
import com.cbrl.cloud.product.dto.mapper.StockMapper;
import com.cbrl.cloud.product.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "stock", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class StockController {

    private final StockService stockService;
    private final StockMapper stockMapper;

    @GetMapping("{product-id}/exist")
    public ApiResponse checkStock(@PathVariable("product-id") Long productId, @RequestParam(defaultValue = "1") Long count) {

        CheckStockDto dto = stockService.checkStock(productId, count);
        return ApiResponse.success(dto);
    }

    @PostMapping
    public ApiResponse createStock(@Valid @RequestBody StockRequest request) {
      stockService.createStock(stockMapper.toStockDto(request));
        return ApiResponse.success();
    }
}
