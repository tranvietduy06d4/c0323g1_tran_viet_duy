package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> displayAll();

    Blog getById(int id);

    void remove(int id);

    void update(Blog blog);
}
