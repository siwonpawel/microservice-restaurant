package com.github.siwonpawel.microservice.restaurant.servicebooking.domain.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String name;
    private Long restaurantId;
    private Long userId;
    private LocalDate date;
    private LocalTime time;
    private String tableId;

}
