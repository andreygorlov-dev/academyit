package com.gorlov.online_shop_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthPageController {

    @GetMapping(value = "/authpage")
    public String main(Model model){
        return "auth";
    }
}
