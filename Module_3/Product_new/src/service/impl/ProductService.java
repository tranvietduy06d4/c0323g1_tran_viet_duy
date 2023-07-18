package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static Scanner scanner =new Scanner(System.in);
    private static IProductRepository productRepository = new ProductRepository();
    @Override
    public void displayAll() {
        List<Product> productList = productRepository.getAll();
        for (Product product:productList) {
            System.out.println(product);
        }
    }

    @Override
    public void add() {
        System.out.println("Vui lòng nhập mã sản phẩm để check: ");
        String code = scanner.nextLine();
        Product productCheck = productRepository.getByCode(code);
        if(productCheck == null) {
            System.out.println("Vui lòng nhập tên sản phẩm mới: ");
            String name = scanner.nextLine();

            System.out.println("Vui lòng nhập giá sản phẩm: ");
            float price = Float.valueOf(scanner.nextLine());

            System.out.println("Vui lòng nhập số lượng sản phẩm: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            System.out.println("Vui lòng nhập mô tả sản phẩm: ");
            String description = scanner.nextLine();

            Product newProduct = new Product(code,name,price,quantity,description);
            productRepository.add(newProduct);
            System.out.println("Bạn đã thêm mới sản phẩm thành công");

        } else {
            System.out.println("Mã sản phẩm này đã tồn tại trên hệ thống nên không thể thêm mới được. Vui lòng thử lại.");
        }


    }

    @Override
    public void delete() {
        System.out.println("Vui lòng nhập mã sản phẩm để xóa: ");
        String code = scanner.nextLine();

        Product productCheck = productRepository.getByCode(code);
        if(productCheck != null) {
            System.out.println("Bạn có thực sự muốn xóa sản phẩm này không?\n" +
                    "Bấm 1. Xóa sản phẩm\n" +
                    "Bấm 2. Hủy\n");
            int choiceDelete = Integer.parseInt(scanner.nextLine());
            switch (choiceDelete) {
                case 1:
                    productRepository.delete(productCheck);
                    System.out.println("Bạn đã xóa thành công sản phẩm");
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Nhập sai ( chỉ được nhập số 1 hoặc 2). Vui lòng thử lại");
            }

        } else {
            System.out.println("Sản phẩm này không tồn tại trên hệ thống. Vui lòng thử lại");
        }
    }

    @Override
    public void getByName() {
        System.out.println("Vui lòng nhập tên sản phẩm để tìm kiếm: ");
        String name = scanner.nextLine();

        List<Product> productSearchList = productRepository.getByName(name);
        if(productSearchList != null) {
            for (Product p:productSearchList) {
                System.out.println(p);
            }
        } else {
            System.out.println("Không có sản phẩm này trên hệ thống");
        }
    }

    @Override
    public void edit() {
        System.out.println("Vui lòng nhập mã sản phẩm để chỉnh sửa: ");
        String code = scanner.nextLine();

        Product product = productRepository.getByCode(code);
        if(product != null) {
            System.out.println("Vui lòng nhập vào tên sản phẩm: ");
            String name = scanner.nextLine();

            System.out.println("Vui lòng nhập vào giá sản phẩm: ");
            float price = Float.valueOf(scanner.nextLine());

            System.out.println("Vui lòng nhập vào số lượng sản phẩm: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            System.out.println("Vui lòng nhập mô tả sản phầm: ");
            String description = scanner.nextLine();

            product.setName(name);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setDescription(description);

            productRepository.edit(product);
            System.out.println("Bạn đã chỉnh sửa thành công sản phẩm");
        } else {
            System.out.println("Không có mã sản phẩm này trên hệ thống. Vui lòng thử lại");
        }
    }


}
