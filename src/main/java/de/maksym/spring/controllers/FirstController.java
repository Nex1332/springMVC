package de.maksym.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

        model.addAttribute("greeting", "Hi my friend " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int firstValue,
                           @RequestParam(value = "b", required = false) int secondValue,
                           @RequestParam(value = "action", required = false) String action,
                           Model model){
        int result = 0;

        switch (action) {
            case "multiplication":
                result = firstValue * secondValue;
                break;
            case "addition":
                result = firstValue + secondValue;
                break;
            case "subtraction":
                result = firstValue - secondValue;
                break;
            case "division":
                result = firstValue / secondValue;
                break;
        }

        model.addAttribute("result",result);

        return "/first/calculator";
    }
}
