package com.example.service;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
//    private static Map<Integer,Product> productList = new HashMap<>();
//    static {
//        productList.put(1,new Product(1,"Banh Chocolate",50000,"Xuat xu Han Quoc","Orion"));
//        productList.put(2,new Product(2,"Banh gao",40000,"Xuat xu Viet Nam","Huong Lan"));
//        productList.put(3,new Product(3,"Ruou vang Lapondser",2500000,"Xuat xu Phap","Lacourse"));
//    }

    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> displayAll() {
        return productRepository.displayAll();
//        return new ArrayList<>(productList.values());
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
//        productList.put(product.getId(),product);
    }

    @Override
    public Product getById(int id) {
        return productRepository.getById(id);
    }

    @Override
    public void edit(Product product) {
        productRepository.edit(product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }
}
