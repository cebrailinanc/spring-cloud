package com.cbrl.cloud.product.service;

import com.cbrl.cloud.product.data.model.Stock;
import com.cbrl.cloud.product.data.repository.StockRepository;
import com.cbrl.cloud.product.dto.CheckStockDto;
import com.cbrl.cloud.product.dto.mapper.StockMapper;
import com.cbrl.cloud.product.service.impl.StockServiceImpl;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

/**
 * Test Naming Convention ==> MethodName_ExpectedBehavior_StateUnderTest
 */
@ExtendWith(MockitoExtension.class)
class StockServiceTest {

    @InjectMocks
    StockServiceImpl stockService;

    @Mock
    private StockRepository repository;
    @Mock
    private StockMapper stockMapper;

    private EasyRandom easyRandom = new EasyRandom(new EasyRandomParameters().randomize(Long.class, () -> 2L));

    @Test
    void checkStock_True_StockIsEnough() {
        Mockito.when(repository.findByProductId(Mockito.anyLong()))
                .thenReturn(Optional.of(easyRandom.nextObject(Stock.class)));
        CheckStockDto checkStockDto = stockService.checkStock(2L, 2L);

        Assertions.assertTrue(checkStockDto.getExistStock());
    }

    @Test
    void checkStock_False_StockIsInsufficient() {
        Mockito.when(repository.findByProductId(Mockito.anyLong()))
                .thenReturn(Optional.of(easyRandom.nextObject(Stock.class)));
        CheckStockDto checkStockDto = stockService.checkStock(2L, 3L);

        Assertions.assertFalse(checkStockDto.getExistStock());
    }

}