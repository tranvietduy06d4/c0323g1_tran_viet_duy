package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> getAll();

    void insertProduct(Product product);

    void removeProduct(Product product);

    Product getById(String id);
}
