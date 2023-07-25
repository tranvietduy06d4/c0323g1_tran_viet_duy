package com.example.repository;

import com.example.model.BlogType;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface IBlogTypeRepository extends JpaRepository<BlogType,Integer> {

}
