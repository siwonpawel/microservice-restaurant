package com.github.siwonpawel.microservice.restaurant.servicerestaurant.domain.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "tablee")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    int capacity;
}
