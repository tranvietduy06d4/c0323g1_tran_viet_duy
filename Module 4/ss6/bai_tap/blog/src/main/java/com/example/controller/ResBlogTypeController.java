package com.example.controller;

import com.example.model.Blog;
import com.example.model.BlogType;
import com.example.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blogTypes")
public class ResBlogTypeController {
    @Autowired
    private IBlogTypeService blogTypeService;

    @GetMapping("")
    public ResponseEntity<List<BlogType>> showList() {
        List<BlogType> blogTypeList = blogTypeService.findAll();
        if (blogTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogTypeList,HttpStatus.OK);
    }
}
