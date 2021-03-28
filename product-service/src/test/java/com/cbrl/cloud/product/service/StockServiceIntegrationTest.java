package com.cbrl.cloud.product.service;

import com.cbrl.cloud.product.api.error.handling.advice.exception.BusinessException;
import com.cbrl.cloud.product.data.model.Stock;
import com.cbrl.cloud.product.data.repository.StockRepository;
import com.cbrl.cloud.product.dto.StockDto;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class StockServiceIntegrationTest {

    @Autowired
    StockService stockService;

    @MockBean
    StockRepository stockRepository;

    @Test
    void createStock() {
        StockDto stockDto = new StockDto(1L, 1L);
        Mockito.when(stockRepository.findByProductId(Mockito.anyLong())).thenReturn(Optional.of(new Stock()));

        Throwable throwable = Assertions.catchThrowable(() -> stockService.createStock(stockDto));

        BDDAssertions.then(throwable).isInstanceOf(BusinessException.class);

    }

}
