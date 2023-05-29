package ss17_iobinary_file_and_serialization.bai_tap.bai_tap_1_quan_ly_san_pham.controller;

import ss17_iobinary_file_and_serialization.bai_tap.bai_tap_1_quan_ly_san_pham.service.IProductService;
import ss17_iobinary_file_and_serialization.bai_tap.bai_tap_1_quan_ly_san_pham.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    private Scanner scanner = new Scanner(System.in);
    private IProductService productService = new ProductService();
    public void showMenu() {
        int choice;
        do {
            System.out.println("-------------------------------------");
            System.out.println("Vui lòng bấm số để chọn chức năng tương ứng");
            System.out.println("Bấm 1. Hiển thị danh sách tất cả sản phẩm");
            System.out.println("Bấm 2. Thêm mới sản phẩm");
            System.out.println("Bấm 3. Tìm kiếm thông tin sản phẩm và lưu vào file");
            System.out.println("Bấm 4. Thoát chương trình");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    productService.displayAll();
                    break;
                case 2:
                    productService.add();
            }

        } while (true);

    }
}
