package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class ProductService implements IProductService {

    IProductRepository productRepository = new ProductRepository();

    @Override
    public void displayAll() {
        List<Product> productList = productRepository.getAll();
        for (Product p : productList) {
            System.out.println(p);
        }
    }

    @Override
    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập vào Id của sản phẩm cần thêm mới: ");
        String idProduct = scanner.nextLine();
        Product productCheck = productRepository.getById(idProduct);
        if (productCheck == null) {
            System.out.println("Vui lòng nhập vào tên sản phẩm: ");
            String name = scanner.nextLine();
            System.out.println("Vui lòng nhập vào giá của sản phẩm: ");
            float price = Float.valueOf(scanner.nextLine());
            System.out.println("Vui lòng nhập số lượng sản phẩm: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Vui lòng nhập mô tả sản phẩm: ");
            String description = scanner.nextLine();
            Product newProduct = new Product(idProduct, name, price, quantity, description);
            productRepository.insertProduct(newProduct);
        } else {
            System.out.println("Mã số ID này đã tồn tại trên hệ thống. Vui lòng thử lại");
        }
    }

    @Override
    public void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập vào Id của sản phẩm cần xóa: ");
        String idProduct = scanner.nextLine();
        Product productCheck = productRepository.getById(idProduct);
        if (productCheck != null) {
            System.out.println("Bạn có thực sự muốn xóa sản phẩm mã ID: " + productCheck.getId() + " Tên sản phẩm: " + productCheck.getName() + " Vui lòng chọn:\n" +
                    "1. Xóa sản phẩm\n" +
                    "2. Suy nghĩ thêm");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productRepository.removeProduct(productCheck);
                    System.out.println("Bạn đã xóa thành công sản phẩm");
                    break;
                case 2:
                    break;
                default:
            }
        } else {
            System.out.println("Mã số ID này không tồn tại trên hệ thống. Vui lòng thử lại");
        }
    }

}
