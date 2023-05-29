package ss17_iobinary_file_and_serialization.bai_tap.bai_tap_1_quan_ly_san_pham.service.impl;

import ss17_iobinary_file_and_serialization.bai_tap.bai_tap_1_quan_ly_san_pham.model.Product;
import ss17_iobinary_file_and_serialization.bai_tap.bai_tap_1_quan_ly_san_pham.repository.IProductRepository;
import ss17_iobinary_file_and_serialization.bai_tap.bai_tap_1_quan_ly_san_pham.repository.impl.ProductRepository;
import ss17_iobinary_file_and_serialization.bai_tap.bai_tap_1_quan_ly_san_pham.service.IProductService;

import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private Scanner scanner = new Scanner(System.in);

    IProductRepository productRepository = new ProductRepository();


    @Override
    public void displayAll() {
        List<Product> productList = productRepository.getAll();
        for (Product p: productList) {
            System.out.println(p);
        }
    }

    @Override
    public void add() {
        System.out.println("Vui lòng nhập vào Id của sản phẩm bạn muốn thêm vào: ");
        String id = scanner.nextLine();



    }
}
