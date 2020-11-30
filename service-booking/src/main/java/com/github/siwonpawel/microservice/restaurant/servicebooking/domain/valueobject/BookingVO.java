package com.github.siwonpawel.microservice.restaurant.servicebooking.domain.valueobject;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingVO {

    Long id;

    private Long restaurantId;
    private Long userId;
    private LocalDate date;
    private LocalTime time;
    private String tableId;

}
