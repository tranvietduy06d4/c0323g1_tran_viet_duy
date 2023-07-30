package com.example.repository;

import com.example.model.Book;
import com.example.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICodeRepository extends JpaRepository<Code,Integer> {
    Code findCodeByRentCode(int rentCode);
}
