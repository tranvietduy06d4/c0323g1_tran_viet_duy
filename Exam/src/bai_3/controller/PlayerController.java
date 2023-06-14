package bai_3.controller;

import bai_3.service.IPlayerService;
import bai_3.service.impl.PlayerService;

import java.util.Scanner;

public class PlayerController {
    private static Scanner scanner = new Scanner(System.in);
    private static IPlayerService playerService = new PlayerService();
    public void showMenu() {
        do {
            System.out.println("Vui lòng nhập vào số từ 1 - 4 để lựa chọn chức năng tương ứng: \n" +
                    "Bấm 1. Hiển thị danh sách cầu thủ\n" +
                    "Bấm 2. Thêm mới cầu thủ\n" +
                    "Bấm 3. Thực hiện sút penalty\n" +
                    "Bấm 0. Thoát chương trình");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    playerService.getAll();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.exit(1);
                default:
                    System.out.println("Nhập sai. Số bạn nhập vào không nằm trong khoảng từ 0 đến 3");
            }
        } while (true);

    }
}
