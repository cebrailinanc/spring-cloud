package com.cbrl.spring.cloud.domain.user.data.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    String city;
    String street;

    String address;

}
