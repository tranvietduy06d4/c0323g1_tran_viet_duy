package com.example.repository;
import com.example.model.BlogType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface IBlogTypeRepository extends JpaRepository<BlogType,Integer> {


    Page<BlogType> findBlogTypeByNameContaining(Pageable pageable, String name);
}
