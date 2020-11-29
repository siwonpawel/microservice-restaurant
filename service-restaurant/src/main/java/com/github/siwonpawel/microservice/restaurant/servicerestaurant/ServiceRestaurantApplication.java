package com.github.siwonpawel.microservice.restaurant.servicerestaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRestaurantApplication.class, args);
	}

}
