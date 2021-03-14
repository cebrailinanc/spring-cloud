package com.cbrl.cloud.product.data.repository;

import com.cbrl.cloud.product.data.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {

    Optional<Stock> findByProductId(Long productId);
}
