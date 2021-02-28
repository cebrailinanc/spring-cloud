package com.cbrl.cloud.payment.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Payment {

    @Id
    private Long id;

    private Long userId;
}
