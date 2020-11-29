package com.github.siwonpawel.microservice.restaurant.servicerestaurant.domain.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    @OneToMany(cascade = CascadeType.ALL)
    List<Table> tables = new ArrayList<>();
}
