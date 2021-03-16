package com.cbrl.cloud.product.data.repository;

import com.cbrl.cloud.product.data.model.Stock;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class StockRepositoryTest {

    @Autowired
    private StockRepository repository;

    private EasyRandom easyRandom = new EasyRandom();

    @Test
    void findByProductId_CheckQuery() {
        Stock savedEntity = repository.save(easyRandom.nextObject(Stock.class));
        Optional<Stock> findEntity = repository.findByProductId(savedEntity.getProductId());
        Assertions.assertEquals(savedEntity.getProductId(), findEntity.get().getProductId());
    }

    @Test
    void addStock_Success_UpdateData() {
        Long addCount = 5L;
        Stock entity = new Stock();
        entity.setCount(5L);
        entity.setProductId(1L);
        Stock savedEntity = repository.save(entity);
        repository.addStock(addCount, savedEntity.getProductId());
        Optional<Stock> updatedEntity = repository.findByProductId(savedEntity.getProductId());
        Assertions.assertEquals(updatedEntity.get().getCount(), entity.getCount() + addCount);
    }
}