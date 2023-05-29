package ss17_iobinary_file_and_serialization.bai_tap.bai_tap_1_quan_ly_san_pham.repository;

import ss17_iobinary_file_and_serialization.bai_tap.bai_tap_1_quan_ly_san_pham.model.Product;
import ss17_iobinary_file_and_serialization.bai_tap.bai_tap_1_quan_ly_san_pham.service.impl.ProductService;

import java.util.List;

public interface IProductRepository {
    public List<Product> getAll();
    Product getById(String id);

}
