package service;

import model.Product;

public interface IProductService {
    void displayAll();

    void addProduct();
    void deleteProduct();

    void searchProduct();

    void updateProduct();

    void sortProductPrice();
}
