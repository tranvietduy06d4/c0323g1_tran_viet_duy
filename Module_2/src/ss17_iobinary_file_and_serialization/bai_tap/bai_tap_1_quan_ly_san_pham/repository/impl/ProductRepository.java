package ss17_iobinary_file_and_serialization.bai_tap.bai_tap_1_quan_ly_san_pham.repository.impl;

import ss17_iobinary_file_and_serialization.bai_tap.bai_tap_1_quan_ly_san_pham.model.Product;
import ss17_iobinary_file_and_serialization.bai_tap.bai_tap_1_quan_ly_san_pham.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        Product product1 = new Product("P-001", "Bánh Chocopie", 50000, "Orion", "Bánh xuất xứ Mỹ");
        Product product2 = new Product("P-002", "Bánh Rồng vàng", 40000, "Dragon", "Bánh xuất xứ Hải Dương");
        Product product3 = new Product("P-003", "Kem socola", 30000, "Vinamilk", "Bánh xuất xứ Việt Nam");
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public Product getById(String id) {
        return null;
    }
}
