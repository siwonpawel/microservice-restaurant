package com.github.siwonpawel.microservice.restaurant.servicerestaurant.controller;

import com.github.siwonpawel.microservice.restaurant.servicerestaurant.domain.model.entity.Restaurant;
import com.github.siwonpawel.microservice.restaurant.servicerestaurant.domain.service.RestaurantService;
import com.github.siwonpawel.microservice.restaurant.servicerestaurant.domain.valueobject.RestaurantVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/v1/restaurants")
public class RestaurantController {

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<Collection<Restaurant>> getRestaurants() {
        log.info(() -> "invoke RestaurantController.getRestaurants()");
        Collection<Restaurant> all = restaurantService.findAll();

        return all.size() > 0 ?
                ResponseEntity.ok(all) :
                ResponseEntity.noContent().build();
    }

    @GetMapping("/byname")
    public ResponseEntity<Collection<Restaurant>> findByName(@RequestParam("name") String name) {
        log.info("invoke RestaurantController.findByName(): {}", name);
        Collection<Restaurant> restaurants = restaurantService.findByName(name);

        return restaurants.size() > 0 ?
                ResponseEntity.ok(restaurants) :
                ResponseEntity.noContent().build();
    }

    @GetMapping("/{restaurant_id}")
    public ResponseEntity<Restaurant> findById(@PathVariable("restaurant_id") Long id) {
        log.info("invoke RestaurantController.findById(): {}", id);
        Optional<Restaurant> restaurant = restaurantService.findById(id);

        return restaurant.map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody RestaurantVO restaurantVO) {
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(restaurantVO, restaurant);

        Restaurant saved = restaurantService.add(restaurant);

        return saved != null ?
                ResponseEntity.ok(saved) :
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
