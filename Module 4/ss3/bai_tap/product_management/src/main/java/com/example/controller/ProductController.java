package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Product> productList = productService.displayAll();
        model.addAttribute("productList",productList);
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String productDetail(@PathVariable int id, Model model) {
        model.addAttribute("product",productService.getById(id));
        return "detail";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product",productService.getById(id));
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(Product product,RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message","Delete product successful");
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String edit(@PathVariable int id, Model model) {
        System.out.println(id);
        model.addAttribute("product",productService.getById(id));
        return "update";
    }

    @PostMapping("/update")
    public String edit(Product product,RedirectAttributes redirectAttributes) {
        productService.edit(product);
        redirectAttributes.addFlashAttribute("message","Update product successful");
        return "redirect:/";
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        model.addAttribute("product",new Product());
        return ("create");
    }

    @PostMapping("create")
    public String create(Product product, RedirectAttributes redirectAttributes) {
        productService.add(product);
        redirectAttributes.addFlashAttribute("message","Add new product successful");
        return "redirect:/";
    }



}
