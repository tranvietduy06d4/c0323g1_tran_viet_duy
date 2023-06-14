package view;

import controller.ProductController;

import java.util.Scanner;

public class ProductView {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductController productController = new ProductController();
    public static void main(String[] args) {
        System.out.println("Chào mừng đến với chương trình quản lý sản phẩm");
        productController.showMenu();
    }
}
