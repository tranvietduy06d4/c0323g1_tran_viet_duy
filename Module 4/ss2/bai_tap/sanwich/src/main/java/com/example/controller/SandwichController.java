package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String showSelectForm() {
        return "selectCondiment";
    }

    @PostMapping("/create")
    public String save(@RequestParam(value = "condiment" ,required = false) String[] condiment, Model model) {
        if (condiment == null || condiment.length == 0) {
            return "error";
        } else {
            model.addAttribute("listCondiment", condiment);
            return "result";
        }
    }
}
