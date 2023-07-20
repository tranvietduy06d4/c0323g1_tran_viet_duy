package com.example.controller;

import com.example.model.EmailConfig;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;
    @ModelAttribute("language")
    public String[] getLanguage() {
        return new String[] {"English","Vietnamese","Japanese","Chinese"};
    }

    @ModelAttribute("pageSize")
    public int[] getPageSize() {
        return new int[] {5,10,15,25,50,100};
    }

//    @GetMapping ("/")
//    public String createForm(Model model) {
//        model.addAttribute("emailConfig",new EmailConfig());
//        return "home";
//    }
    @GetMapping("/info")
    public String showInfo(Model model) {
        EmailConfig emailConfig = emailService.display();
        model.addAttribute("email",emailConfig);
        return "info";
    }

    @GetMapping("/update")
    public String showUpdateForm(Model model ) {
        model.addAttribute("emailConfig",emailService.display());
        return "update";
    }

    @PostMapping("/update")
    public String save(@ModelAttribute EmailConfig emailConfig, RedirectAttributes redirectAttributes) {
        emailService.update(emailConfig);
        redirectAttributes.addFlashAttribute("message","Save new email config successful");
        return "redirect:/info";
    }





}
