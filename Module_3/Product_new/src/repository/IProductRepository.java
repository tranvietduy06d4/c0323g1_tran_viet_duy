package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();

    Product getByCode(String code);

    void add(Product newProduct);
    void delete(Product product);

    List<Product> getByName(String name);

    void edit(Product product);
}
