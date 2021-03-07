package com.cbrl.cloud.product;

import com.cbrl.cloud.product.dto.StockDto;
import com.cbrl.cloud.product.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Autowired
    private StockService stockService;

    @Override
    public void run(String... args) {
        stockService.createStock(new StockDto(10L,5L));
        stockService.createStock(new StockDto(11L,1L));
        stockService.createStock(new StockDto(12L,2L));
        stockService.createStock(new StockDto(13L,3L));
    }
}
