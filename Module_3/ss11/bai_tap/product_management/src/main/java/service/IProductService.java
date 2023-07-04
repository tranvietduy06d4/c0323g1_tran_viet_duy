package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> displayAll();

    void create(Product product);
    Product getById(int id);
    void edit(int id, Product product);
    public void remove(int id);

}
