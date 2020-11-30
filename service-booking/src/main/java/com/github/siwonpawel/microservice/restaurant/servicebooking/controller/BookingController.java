package com.github.siwonpawel.microservice.restaurant.servicebooking.controller;

import com.github.siwonpawel.microservice.restaurant.servicebooking.domain.model.entity.Booking;
import com.github.siwonpawel.microservice.restaurant.servicebooking.domain.service.BookingService;
import com.github.siwonpawel.microservice.restaurant.servicebooking.domain.valueobject.BookingVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<Collection<Booking>> findByName(@RequestParam("name") String name) {
        Collection<Booking> byName = bookingService.findByName(name);

        return byName.size() > 0 ?
                ResponseEntity.ok(byName) :
                ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> findById(@PathVariable("id") Long id) {
        Booking byId = bookingService.findById(id);

        return byId != null ?
                ResponseEntity.ok(byId) :
                ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Booking> add(@RequestBody BookingVO bookingVO) {
        Booking booking = new Booking();
        BeanUtils.copyProperties(bookingVO, booking);

        Booking saved =  bookingService.add(booking);

        return saved != null ?
                ResponseEntity.status(HttpStatus.CREATED).build() :
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
