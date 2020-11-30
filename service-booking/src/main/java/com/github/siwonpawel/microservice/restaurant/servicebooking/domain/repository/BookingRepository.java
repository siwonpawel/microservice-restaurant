package com.github.siwonpawel.microservice.restaurant.servicebooking.domain.repository;

import com.github.siwonpawel.microservice.restaurant.servicebooking.domain.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByName(String name);
}
