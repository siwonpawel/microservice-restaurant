package com.github.siwonpawel.microservice.restaurant.serviceuser.domain.repository;

import com.github.siwonpawel.microservice.restaurant.serviceuser.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Collection<User> findByName(String name);
}
