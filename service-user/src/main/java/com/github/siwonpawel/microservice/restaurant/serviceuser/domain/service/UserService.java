package com.github.siwonpawel.microservice.restaurant.serviceuser.domain.service;

import com.github.siwonpawel.microservice.restaurant.serviceuser.domain.model.entity.User;
import com.github.siwonpawel.microservice.restaurant.serviceuser.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User add(User user) {
        return userRepo.save(user);
    }

    public User update(User user) {
        return userRepo.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    public Collection<User> findAll() {
        return userRepo.findAll();
    }

    public Collection<User> findByName(String name) {
        return userRepo.findByName(name);
    }
}
