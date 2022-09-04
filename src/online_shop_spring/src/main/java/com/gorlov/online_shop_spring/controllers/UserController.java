package com.gorlov.online_shop_spring.controllers;

import com.gorlov.online_shop_spring.exceptions.UserNotFoundException;
import com.gorlov.online_shop_spring.models.User;
import com.gorlov.online_shop_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/user")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable(name = "id") long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping(value = "/user")
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
