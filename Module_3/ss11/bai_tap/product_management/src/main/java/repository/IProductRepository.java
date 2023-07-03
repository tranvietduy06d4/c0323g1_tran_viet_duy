package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    public List<Product> displayAll();

    public void create(Product product);

    public Product getById(int id);

    public void edit(int id, Product product);


}
