package my.app.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model){
        return "index";
    }

    @GetMapping("/contacts")
    public String contacts(Model model) {
        return "contactsPage";
    }

}
