package com.cbrl.cloud.payment.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "USER-SERVICE" )
public interface UserClient {

    @GetMapping("/api/users/{id}")
    Boolean idForbidden(Long id);
}
