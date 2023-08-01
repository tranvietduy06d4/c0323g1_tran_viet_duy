package com.example.controller;

import com.example.model.Blog;
import com.example.model.BlogType;
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


@Controller
@RequestMapping("/category")
public class BlogTypeController {

    @Autowired
    private IBlogTypeService blogTypeService;
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("blogType",new BlogType());
        model.addAttribute("blogTypeList",blogTypeService.findAll());
        return "/blogType/create";
    }

    @PostMapping("/create")
    public String createBlogType(@ModelAttribute BlogType blogType, RedirectAttributes redirectAttributes) {
        blogTypeService.createBlogType(blogType);
        redirectAttributes.addFlashAttribute("message","Create new blog type success");
        return "redirect:/category/list";
    }


    @GetMapping("/list")
    public String showList(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "") String searchName,
                           Model model) {
        Pageable pageable = PageRequest.of(page,2, Sort.by("name").ascending());
        Page<BlogType> blogTypePage = blogTypeService.findAllByName(pageable,searchName);
        model.addAttribute("blogTypeList",blogTypePage);
        return "blogType/list";
    }

    @GetMapping("/edit/{id}")
    public String blogTypeEdit(@PathVariable int id, Model model) {
        model.addAttribute("blogType",blogTypeService.findBlogTypeById(id));
        return "blogType/edit";
    }
    @PostMapping("/edit")
    public String blogTypeUpdate(@ModelAttribute BlogType blogType, RedirectAttributes redirectAttributes) {

        blogTypeService.createBlogType(blogType);
        redirectAttributes.addFlashAttribute("message","Update successful");
        return "redirect:/category/list";
    }

}
