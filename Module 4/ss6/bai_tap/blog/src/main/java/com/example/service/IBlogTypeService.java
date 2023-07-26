package com.example.service;

import com.example.model.BlogType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogTypeService {
    List<BlogType> findAll();

    void createBlogType(BlogType blogType);

    Page<BlogType> findAllByName(Pageable pageable, String searchName);
}
