package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.*;

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

    @Override
    public List<Product> getByName(String name) {
        List<Product> productSearchList = new ArrayList<>();
        for (Product p: productList) {
            if(p.getName().toLowerCase().contains(name)) {
                productSearchList.add(p);
            }
        }
        if(!productSearchList.isEmpty()) {
            return productSearchList;
        } else {
            return null;
        }

    }

    @Override
    public void sortProductPriceUp() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                return product1.getPrice() - product2.getPrice();
            }
        });
    }

    @Override
    public void sortProductPriceDown() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                return product2.getPrice() - product1.getPrice();
            }
        });
    }
}
