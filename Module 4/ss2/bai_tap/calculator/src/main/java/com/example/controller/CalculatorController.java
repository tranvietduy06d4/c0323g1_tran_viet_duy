package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String showCalculator() {
        return "home";
    }

    @PostMapping("calculate")
    public String calculate(@RequestParam("firstNumber") int firstNumber, @RequestParam("secondNumber") int secondNumber, @RequestParam("operator") String operator, Model model) {
        int result = 0;
        String message = "";
        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if(secondNumber == 0) {
                    message = "Không thể thực hiện phép tính chia do mẫu số phải khác 0";
                } else {
                    result = firstNumber / secondNumber;
                }
                break;
        }
        model.addAttribute("result",result);
        model.addAttribute("message",message);
        return "result";
    }



}
