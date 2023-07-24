package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> displayAll();

    void add(Product product);

    Product getById(int id);

    void edit(Product product);

    void remove(int id);
}
