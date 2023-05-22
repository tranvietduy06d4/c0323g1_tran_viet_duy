package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductRepository implements IProductRepository {

    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product("P-001","Bánh Chocopie",45000,20,"Bánh xuất xứ từ Pháp"));
        productList.add(new Product("P-002","Kẹo Bò sữa",35000,25,"Kẹo xuất xứ từ Pháp"));
        productList.add(new Product("P-003","Dầu ăn Neptune",45000,30,"Dầu xuất xứ Việt Nam"));
    }



    @Override
    public List<Product> getAll() {
        return productList;

    }

    @Override
    public void insertProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        productList.remove(product);
    }

    @Override
    public Product getById(String id) {
        for (Product p: productList) {
            if(p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}
