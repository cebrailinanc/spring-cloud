package com.cbrl.cloud.payment.controller;

import com.cbrl.cloud.payment.restclient.UserClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/payment")
@Log4j2
public class PaymentController {

    private final UserClient userClient;

    @GetMapping
    public ResponseEntity<Boolean> pay() {

        log.info("Called payment-service");
        Boolean forbidden = userClient.idForbidden(1L);
        log.info("forbidden  response :{}", forbidden);
        return ResponseEntity.ok(forbidden);
    }

}
