package com.example.service;

import com.example.model.BlogType;
import com.example.repository.IBlogTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTypeService implements IBlogTypeService{

    @Autowired
    private IBlogTypeRepository blogTypeRepository;
    @Override
    public List<BlogType> findAll() {
        return blogTypeRepository.findAll();
    }
}
