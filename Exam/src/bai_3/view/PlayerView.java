package bai_3.view;

import bai_3.controller.PlayerController;

import java.util.Scanner;

public class PlayerView {
    private static Scanner scanner = new Scanner(System.in);
    private static PlayerController playerController = new PlayerController();
    public static void main(String[] args) {
        System.out.println("Chào mừng đến với chương trình quản lý cầu thủ bóng đá");
        playerController.showMenu();
    }
}
