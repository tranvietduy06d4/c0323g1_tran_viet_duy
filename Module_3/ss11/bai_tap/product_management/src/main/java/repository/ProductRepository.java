package repository;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository{
//    public Product(int id, String name, double price, String description, String producer) {
    private static Map<Integer, Product> products = new HashMap<>();
    static {
        products.put(1,new Product(1,"Banh gao",25000,"Xuat xu Han Quoc","Abc"));
        products.put(2,new Product(2,"Keo cam",20000,"Xuat xu Dai Loan","Xyz"));
        products.put(3,new Product(3,"Com chay",27000,"Xuat xu Viet Nam","Long An"));
        products.put(4,new Product(4,"Coca Cola",10000,"Xuat xu Viet nam","Pepsi"));
    }


    @Override
    public List<Product> displayAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void create(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product getById(int id) {
        return products.get(id);
    }

    @Override
    public void edit(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }


}
