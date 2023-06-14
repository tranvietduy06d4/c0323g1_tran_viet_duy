package controller;

import service.IProductService;
import service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    private static Scanner scanner = new Scanner(System.in);
    private static IProductService productService = new ProductService();
    public void showMenu() {
        do {
            System.out.println("Vui lòng bấm số để chọn chức năng tương ứng: ");
            System.out.println("Bấm 1. Hiển thị danh sách tất cả sản phẩm\n" +
                    "Bấm 2. Thêm mới sản phẩm\n" +
                    "Bấm 3. Xóa sản phẩm\n" +
                    "Bấm 4. Tìm kiếm sản phẩm theo tên\n" +
                    "Bấm 5. Chỉnh sửa sản phẩm\n" +
                    "Bấm 6. Sắp xếp sản phẩm theo giá tăng dần\n" +
                    "Bấm 7. Thoát chương trình");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productService.displayAll();
                    break;
                case 2:
                    productService.add();
                    break;
                case 3:
                    productService.delete();
                    break;
                case 4:
                    productService.getByName();
                    break;
                case 5:
                    productService.edit();
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(1);
                default:
                    System.out.println("Sai. Vui lòng nhập số từ 1-5 để chọn chức năng tương ứng");
            }
        } while (true);

    }
}
