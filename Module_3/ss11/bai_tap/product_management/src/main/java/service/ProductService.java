package service;

import model.Product;
import repository.IProductRepository;
import repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> displayAll() {
        return productRepository.displayAll();
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public Product getById(int id) {
        return productRepository.getById(id);
    }

    @Override
    public void edit(int id, Product product) {
        productRepository.edit(id, product);
    }
}
