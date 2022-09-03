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

    /**
     * Получить список всех пользователей
     * Пример запроса GET:http://localhost:8080/user/
     * @return List<User>
     */
    @GetMapping(value = "/user")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * Получить пользователя по id
     * Пример запроса GET:http://localhost:8080/user/1
     * @param id идентификатор пользователя
     * @return User
     * @throws UserNotFoundException пользователь не найден
     */
    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable(name = "id") long id) throws UserNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * Создать пользователя
     * Пример запроса POST:http://localhost:8080/user/
     * BODY:
     * {
     *     "name" : "Пертов",
     *     "login" : "Admin",
     *     "password" : "Admin"
     * }
     * @param user пользователь тип User
     * @return ResponseEntity<?>
     */
    @PostMapping(value = "/user")
    public ResponseEntity<?> create(@Valid @RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Удаление пользователя
     * @param id идентификатор
     * @return ResponseEntity<?>
     * @throws UserNotFoundException пользователь не найден
     */
    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) throws UserNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }

}
