package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> displayAll();

    void add(Product product);

    Product getById(int id);

    void edit(int id, Product product);

    void remove(int id);
}
