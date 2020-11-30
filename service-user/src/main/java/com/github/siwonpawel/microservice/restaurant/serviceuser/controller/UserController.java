package com.github.siwonpawel.microservice.restaurant.serviceuser.controller;

import com.github.siwonpawel.microservice.restaurant.serviceuser.domain.model.entity.User;
import com.github.siwonpawel.microservice.restaurant.serviceuser.domain.service.UserService;
import com.github.siwonpawel.microservice.restaurant.serviceuser.domain.valueobject.UserVO;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    protected UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Collection<User>> findByName(@RequestParam("name") String name) {
        log.info("service-user findByName(): {}", name);

        Collection<User> users = userService.findByName(name);

        return users.size() > 0 ?
                ResponseEntity.ok(users) :
                ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        Optional<User> byId = userService.findById(id);

        return byId.map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody UserVO userVO) {
        log.info("invoke add(): {}", userVO);

        User user = new User();
        BeanUtils.copyProperties(userVO, user);

        User saved = userService.add(user);

        return saved != null ?
                ResponseEntity.status(HttpStatus.CREATED).body(saved) :
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
