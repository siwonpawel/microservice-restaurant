package com.github.siwonpawel.microservice.restaurant.servicerestaurant.domain.valueobject;

import com.github.siwonpawel.microservice.restaurant.servicerestaurant.domain.model.entity.Table;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantVO {

    private Long id;
    private String name;
    private List<Table> tables;

}
