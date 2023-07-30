package com.example.service;

import com.example.model.Book;
import com.example.model.Code;

public interface ICodeService {
    void add(int rentCode, Book book);

    void deleteByCode(Code code);

    Code findCodeByRentCode(int rentCode);
}
