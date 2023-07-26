package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    Page<Blog> displayAll(Pageable pageable, String searchName);

    Blog getById(int id);

    void remove(int id);

    void update(Blog blog);

    void createBlog(Blog blog);
}
