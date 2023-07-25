package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private IBlogTypeService blogTypeService;



    @GetMapping("/")
    public String showList(Model model) {
        List<Blog> blogList = blogService.displayAll();
        model.addAttribute("blogList",blogList);
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String blogEdit(@PathVariable int id, Model model) {
        model.addAttribute("blog",blogService.getById(id));
        model.addAttribute("blogTypeList",blogTypeService.findAll());
        return "edit";
    }
    @PostMapping("/edit")
    public String blogUpdate(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setPostingDate(Date.valueOf(LocalDate.now()));
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("message","Update successful");
        return "redirect:/";
    }
    @GetMapping("/detail/{id}")
    public String blogDetail(@PathVariable int id, Model model) {
        model.addAttribute("blog",blogService.getById(id));
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String blogDelete(@PathVariable int id, Model model) {
        model.addAttribute("blog",blogService.getById(id));
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String blogRemove(@PathVariable int id) {
        blogService.remove(id);
        return "redirect:/";
    }
}
