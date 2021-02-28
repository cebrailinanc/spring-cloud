package com.cbrl.cloud.payment.controller;

import com.cbrl.cloud.payment.restclient.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final UserClient userClient;

    @GetMapping
    public ResponseEntity pay() {
        Boolean forbidden = userClient.idForbidden(1L);
        System.out.println("forbidden" + forbidden);
        return ResponseEntity.ok(forbidden);
    }

}
