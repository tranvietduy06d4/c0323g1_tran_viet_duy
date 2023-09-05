package com.example.controller;


import com.example.model.Category;
import com.example.model.Product;
import com.example.service.ICategoryService;
import com.example.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<Page<Product>> showList(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "") String searchName,
                                                  @RequestParam(defaultValue = "0") int idCategory) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("quantity").ascending());
        Page<Product> productPage;
        if (idCategory == 0) {
            productPage = productService.displayAll(pageable, searchName);
        } else {
            productPage = productService.displayAll(pageable, searchName, idCategory);
        }

        List<Category> categoryList = categoryService.findAll();
//        if (productPage.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> showDetail(@PathVariable int id) {
        Product product = productService.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @PatchMapping("/edit")
    public ResponseEntity<Product> updateProduct( @RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int id) {
        productService.removeProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
