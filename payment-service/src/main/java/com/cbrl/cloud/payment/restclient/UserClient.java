package com.cbrl.cloud.payment.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "USER-SERVICE" )
public interface UserClient {

    @GetMapping("/api/users/{id}")
    Boolean idForbidden(@PathVariable Long id);
}
