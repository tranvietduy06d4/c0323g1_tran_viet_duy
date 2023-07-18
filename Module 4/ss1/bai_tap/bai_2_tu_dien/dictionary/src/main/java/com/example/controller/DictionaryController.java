package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;
    @GetMapping("/")
    public String searchForm() {
        return "searchForm";
    }

    @PostMapping("/search")
    public String translateToVietnamese(@RequestParam String englishWord, Model model) {
        String vietnameseWord = dictionaryService.translate(englishWord);
        if (vietnameseWord == null) {
            model.addAttribute("vietnameseWord","Không tìm thấy từ này trong từ điển");
        } else {
            model.addAttribute("vietnameseWord",vietnameseWord);
        }
        return "result";
    }
}
