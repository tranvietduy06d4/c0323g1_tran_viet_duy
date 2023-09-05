package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> displayAll(Pageable pageable, String searchName, int idCategory);
    Page<Product> displayAll(Pageable pageable, String searchName);

    void save(Product product);

    Product findById(int id);

    void removeProduct(int id);
}
