package controller;

import service.IProductService;
import service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    private static Scanner scanner = new Scanner(System.in);
    private static IProductService productService = new ProductService();
    public static void showMenu() {


        do {
            System.out.println("-----------------------------------------");
            System.out.println("Vui lòng nhập số để lựa chọn chức năng tương ứng: \n" +
                    "1. Hiển thị danh sách sản phẩm \n" +
                    "2. Sắp xếp sản phẩm theo thứ tự giá tăng dần/ giảm dần\n" +
                    "3. Tìm kiếm sản phẩm theo tên \n" +
                    "4. Sửa thông tin sản phẩm\n" +
                    "5. Thêm sản phẩm\n" +
                    "6. Xóa sản phẩm\n" +
                    "0. Thoát chương trình");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productService.displayAll();
                    break;
                case 3:
                    productService.searchProduct();
                    break;
                case 4:
                    productService.updateProduct();
                    break;
                case 5:
                    productService.addProduct();
                    break;
                case 6:
                    productService.deleteProduct();
                case 0:
                    System.exit(1);
            }

        } while (true);
    }
}
