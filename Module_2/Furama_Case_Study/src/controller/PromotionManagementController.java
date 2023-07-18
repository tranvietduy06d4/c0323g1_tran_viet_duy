package controller;




import java.util.Scanner;

public class PromotionManagementController {
    private static Scanner scanner = new Scanner(System.in);
//    private static IPromotionService promotionService = new PromotionService();
    public static void displayPromotionMenu() {
        do {
            System.out.println("Please enter number from 1 to 4 to select service: ");
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
//                    promotionService.displayListServiceCustomer();
                    break;
                case 2:
//                    promotionService.displayListVoucherCustomer();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong. It is not number format. Please try again");
            }
        } while (true);

    }
}
