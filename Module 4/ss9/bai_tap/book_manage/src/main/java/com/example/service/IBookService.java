package com.example.service;

import com.example.model.Book;

import java.util.List;

public interface IBookService {
    public List<Book> findAll();

    Book findById(int id);
    void add(Book book);
}
