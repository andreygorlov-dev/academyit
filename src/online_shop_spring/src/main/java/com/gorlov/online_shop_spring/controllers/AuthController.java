package com.gorlov.online_shop_spring.controllers;

import com.gorlov.online_shop_spring.exceptions.UserAuthException;
import com.gorlov.online_shop_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository repository;

    @Autowired
    public AuthController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody com.gorlov.online_shop_spring.models.User getAuthUser() throws UserAuthException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        User user = (principal instanceof User) ? (User) principal : null;
        if (Objects.nonNull(user)) {
            return repository.getByLogin(user.getUsername());
        }
        throw new UserAuthException();
    }
}
