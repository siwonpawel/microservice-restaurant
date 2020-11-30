package com.github.siwonpawel.microservice.restaurant.servicebooking.domain.service;

import com.github.siwonpawel.microservice.restaurant.servicebooking.domain.model.entity.Booking;
import com.github.siwonpawel.microservice.restaurant.servicebooking.domain.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookingService {

    private BookingRepository bookingRepo;

    @Autowired
    public BookingService(BookingRepository bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public Booking add(Booking booking) {
        return bookingRepo.save(booking);
    }

    public Collection<Booking> findByName(String name) {
        return bookingRepo.findByName(name);
    }

    public Booking update(Booking booking) {
        return bookingRepo.save(booking);
    }

    public void delete(Booking booking) {
        bookingRepo.delete(booking);
    }

    public Booking findById(Long id) {
        return bookingRepo.getOne(id);
    }
}
