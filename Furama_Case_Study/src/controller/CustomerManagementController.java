package controller;

import service.ICustomerService;
import service.impl.CustomerService;

import java.util.Scanner;

public class CustomerManagementController {
    private static Scanner scanner = new Scanner(System.in);
    private static ICustomerService customerService = new CustomerService();
    public static void displayCustomerMenu() {
        do {
            System.out.println("Please enter number from 1 to 4 to select service: ");
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Return main menu");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
//                    customerService.displayListCustomer();
                    break;
                case 2:
//                    customerService.addNewCustomer();
                    break;
                case 3:
//                    customerService.editCustomer();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong. It is not number format. Please try again");
            }
        } while (true);

    }
}
