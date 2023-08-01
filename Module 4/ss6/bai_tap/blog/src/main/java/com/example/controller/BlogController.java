package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private IBlogTypeService blogTypeService;


    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("blogTypeList",blogTypeService.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String createNewBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blog.setPostingDate(Date.valueOf(LocalDate.now()));
        blogService.createBlog(blog);
        redirectAttributes.addFlashAttribute("message","successfully");
        return "redirect:/";
    }




    @GetMapping("/")
    public String showList(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "") String searchName,
                           Model model) {
        Pageable pageable = PageRequest.of(page,2, Sort.by("title").ascending());
        Page<Blog> blogPage = blogService.displayAll(pageable,searchName);
        model.addAttribute("blogList",blogPage);
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
