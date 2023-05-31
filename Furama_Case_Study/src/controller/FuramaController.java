package controller;

import java.util.Scanner;

public class FuramaController {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        do {
            System.out.println("-------------------------------------------------------");
            System.out.println("Please enter number from 1 to 6 to choose service: ");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException n) {
                System.out.println("It is not number format");
            } catch (Exception e) {
                System.out.println("Error!!!");
            }

            switch (choice) {
                case 1:
                    EmployeeManagementController.displayEmployeeMenu();
                    break;
                case 2:
                    CustomerManagementController.displayCustomerMenu();
                    break;
                case 3:
                    FacilityManagementController.displayFacilityMenu();
                    break;
                case 4:
                    BookingManagementController.displayBookingMenu();
                    break;
                case 5:
                    PromotionManagementController.displayPromotionMenu();
                    break;
                case 6:
                    System.out.println("Thanks you for using our service. See you again!!!");
                    System.exit(1);
                default:
                    System.out.println("Wrong. It is not number format. Please try again");
            }
        } while (true);

    }
}
