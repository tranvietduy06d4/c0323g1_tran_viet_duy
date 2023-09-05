package com.example.service;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> displayAll(Pageable pageable, String searchName, int idCategory) {
        return productRepository.findProductByNameContainingAndCategoryId(pageable, "%" + searchName + "%", idCategory);
    }

    @Override
    public Page<Product> displayAll(Pageable pageable, String searchName) {
        return productRepository.findProductByNameContaining(pageable, "%" + searchName + "%");
    }

    @Override
    public void save(Product product) {
        productRepository.saveProduct(product.getId(),product.getName(),
                product.getImportDate(), product.getQuantity(), product.getCategory().getId());
    }

    @Override
    public Product findById(int id) {
        return productRepository.findProductById(id);
    }

    @Override
    public void removeProduct(int id) {
        productRepository.remove(id);
    }
}
