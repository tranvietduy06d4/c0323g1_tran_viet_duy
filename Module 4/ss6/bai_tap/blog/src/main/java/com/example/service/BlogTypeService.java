package com.example.service;

import com.example.model.BlogType;
import com.example.repository.IBlogTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public void createBlogType(BlogType blogType) {
        blogTypeRepository.save(blogType);
    }

    @Override
    public BlogType findBlogTypeById(int id) {
        return blogTypeRepository.findById(id).get();
    }

    @Override
    public Page<BlogType> findAllByName(Pageable pageable, String name) {
        return blogTypeRepository.findBlogTypeByNameContaining(pageable,name);
    }

}
