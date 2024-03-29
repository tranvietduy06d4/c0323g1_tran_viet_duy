package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;
    @GetMapping()
    public String showFormInput() {
        return "calculatorForm";
    }

    @PostMapping("/calculate")
    public String convertMoney(@RequestParam double usd, @RequestParam double rate, Model model) {
        double result = calculatorService.exchangeMoney(usd,rate);
        model.addAttribute("result",result);
        return "result";
    }


}
