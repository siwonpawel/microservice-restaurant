package com.github.siwonpawel.microservice.restaurant.servicerestaurant.domain.service;

import com.github.siwonpawel.microservice.restaurant.servicerestaurant.domain.repository.RestaurantRepository;
import com.github.siwonpawel.microservice.restaurant.servicerestaurant.domain.model.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepo;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }

    public Collection<Restaurant> findAll() {
        return restaurantRepo.findAll();
    }

    public Collection<Restaurant> findByName(String name) {
        return restaurantRepo.findByName(name);
    }

    public Optional<Restaurant> findById(Long id) {
        return restaurantRepo.findById(id);
    }

    public Restaurant add(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }
}
