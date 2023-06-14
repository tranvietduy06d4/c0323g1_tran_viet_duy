package service;

import model.Product;

import java.util.List;

public interface IProductService {
    void displayAll();

    void add();

    void delete();

    void getByName();

    void edit();
}
