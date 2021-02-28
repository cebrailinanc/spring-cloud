package com.cbrl.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class PaymentServiceApplication {

    public static void main(String[] args) {
        ApplicationContext ctx =SpringApplication.run(PaymentServiceApplication.class, args);



        System.out.println("Inspecting the beans");

        String[] beans = ctx.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String name : beans) {
            System.out.println("Bean Name" +name);
        }
    }

}
