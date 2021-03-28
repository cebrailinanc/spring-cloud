package com.cbrl.cloud.product.data.repository;

import com.cbrl.cloud.product.data.model.Stock;
import org.assertj.core.api.BDDAssertions;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.jeasy.random.randomizers.range.LongRangeRandomizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;

@DataJpaTest
class StockRepositoryTest {

    @Autowired
    private StockRepository repository;

    //TestEntityManager

    private EasyRandom easyRandom = new EasyRandom(new EasyRandomParameters().randomize(Long.class, new LongRangeRandomizer(1L, 100L)).excludeField(FieldPredicates.named("id")));

    @Test
    void findByProductId_CheckQuery() {
        Stock savedEntity = repository.save(easyRandom.nextObject(Stock.class));
        Optional<Stock> findEntity = repository.findByProductId(savedEntity.getProductId());
        Assertions.assertEquals(savedEntity.getProductId(), findEntity.get().getProductId());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 5, 10, 15",
            "1, 2, 8, 10",
            "1, 3, 10, 13"
    })
    void addStock_Success_UpdateData(Long productId, Long initialCount, Long addCount, Long expectedCount) {

        Stock entity = new Stock();
        entity.setCount(initialCount);
        entity.setProductId(productId);
        Stock savedEntity = repository.save(entity);
        repository.addStock(addCount, savedEntity.getProductId());
        Optional<Stock> updatedEntity = repository.findByProductId(savedEntity.getProductId());
        Assertions.assertEquals(expectedCount, updatedEntity.get().getCount());
    }

    @Test
    void test() {
        //given
        Stock savedStock = repository.save(easyRandom.nextObject(Stock.class));

        //when
        Long stocks = repository.getAllStockCount();

        //then
        BDDAssertions.then(savedStock.getId()).isNotNull();
    }

}