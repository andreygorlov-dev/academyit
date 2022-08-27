package my.app.calc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model) {
        return "index";
    }

    @PostMapping("/result")
    public String getResult(Model model, @RequestParam String val1, @RequestParam String val2, @RequestParam String action) {
        model.addAttribute("val1", val1);
        model.addAttribute("val2", val2);
        model.addAttribute("action", action);
        try {

            Double val1D = Double.parseDouble(val1);
            Double val2D = Double.parseDouble(val2);
            switch (action) {
                case "*":
                    model.addAttribute("result", val1D * val2D);
                    break;
                case "/":
                    model.addAttribute("result", val1D / val2D);
                    break;
                case "+":
                    model.addAttribute("result", val1D + val2D);
                    break;
                case "-":
                    model.addAttribute("result", val1D - val2D);
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            model.addAttribute("result", "error");
        }
        return "index";
    }

}
