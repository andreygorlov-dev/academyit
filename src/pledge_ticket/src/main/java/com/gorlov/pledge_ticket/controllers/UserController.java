package com.gorlov.pledge_ticket.controllers;

import com.gorlov.pledge_ticket.exception.UserNotFoundException;
import com.gorlov.pledge_ticket.models.User;
import com.gorlov.pledge_ticket.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
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
    public User getUser(@PathVariable(name = "id") long id) throws Throwable {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping(value = "/user")
    public ResponseEntity<?> create(@Valid @RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) throws UserNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }

}
