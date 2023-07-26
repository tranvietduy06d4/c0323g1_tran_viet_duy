package com.example.repository;

import com.example.model.Blog;
import com.example.model.BlogType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface IBlogTypeRepository extends JpaRepository<BlogType,Integer> {


    Page<BlogType> findAllByNameContains(Pageable pageable, String name);
}
