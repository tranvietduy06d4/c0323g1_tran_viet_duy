package ss17_iobinary_file_and_serialization.bai_tap.bai_tap_1_quan_ly_san_pham.view;

import ss17_iobinary_file_and_serialization.bai_tap.bai_tap_1_quan_ly_san_pham.controller.ProductController;

import java.sql.SQLOutput;

public class ProductView {
    public static void main(String[] args) {
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM");
        ProductController productController = new ProductController();
        productController.showMenu();
    }
}
