package repository.impl;

import data.ReadAndWrite;
import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
//    public Product(String code, String name, float price, int quantity, String description) {

    private static List<Product> productList = new ArrayList<>();



    private static final String PRODUCT_PATH = "src/data/product.csv";


//    public Product(String code, String name, float price, int quantity, String description)

    @Override
    public List<Product> getAll() {
        List<String> string = ReadAndWrite.readFile(PRODUCT_PATH);
        productList.clear();
        String[] info;
        for (String str : string) {
            info = str.split(",");
            productList.add(new Product(info[0], info[1], Float.valueOf(info[2]), Integer.parseInt(info[3]), info[4]));
        }
        return productList;
    }



    @Override
    public Product getByCode(String code) {
        productList = getAll();
        for (Product product : productList) {
            if (product.getCode().equals(code)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void add(Product newProduct) {
        List<String> strings = new ArrayList<>();
        strings.add(newProduct.getCode()+","+newProduct.getName()+","+newProduct.getPrice()+"," +newProduct.getQuantity()+","+newProduct.getDescription());
        ReadAndWrite.writeFile(PRODUCT_PATH,strings,true);
    }

    @Override
    public void delete(Product product) {
        productList = getAll();
        productList.remove(product);
        List<String> strings = new ArrayList<>();
        for (Product temp:productList) {
            strings.add(temp.getCode()+","+temp.getName()+","+temp.getPrice()+","+temp.getQuantity()+","+temp.getDescription());
        }
        ReadAndWrite.writeFile(PRODUCT_PATH,strings,false);
    }

    @Override
    public List<Product> getByName(String name) {
        productList = getAll();
        List<Product> productSearchList = new ArrayList<>();
        for (Product p:productList) {
            if(p.getName().toLowerCase().contains(name.toLowerCase())) {
                productSearchList.add(p);
            }
        }
        if (!productSearchList.isEmpty()) {
            return productSearchList;
        } else {
            return null;
        }
    }

    @Override
    public void edit(Product product) {
        productList = getAll();
        productList.remove(product);


    }
}
