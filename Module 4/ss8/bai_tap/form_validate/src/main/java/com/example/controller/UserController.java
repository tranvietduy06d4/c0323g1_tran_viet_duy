package com.example.controller;

import com.example.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "index";
    }
    @PostMapping("/create")
    public String checkValidation(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "index";
        }
        return "result";
    }

}
