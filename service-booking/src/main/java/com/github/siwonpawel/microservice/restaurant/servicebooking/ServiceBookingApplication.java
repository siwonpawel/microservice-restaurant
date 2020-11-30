package com.github.siwonpawel.microservice.restaurant.servicebooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBookingApplication.class, args);
	}

}
