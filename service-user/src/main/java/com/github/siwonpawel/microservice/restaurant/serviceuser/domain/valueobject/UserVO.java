package com.github.siwonpawel.microservice.restaurant.serviceuser.domain.valueobject;

import lombok.Data;

@Data
public class UserVO {

    private Long id;
    private String name;
    private String address;
    private String city;
    private String phoneNo;

}
