package com.cbrl.cloud.product.data.repository;

import com.cbrl.cloud.product.data.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByProductId(Long productId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Stock s set s.count = s.count + :addCount where s.productId = :productIdParam")
    void addStock(@Param("addCount") Long count, @Param("productIdParam") Long productId);

    @Query("select sum(s.count) from Stock  s where s.productId =s.productId ")
    Long getAllStockCount();
}
