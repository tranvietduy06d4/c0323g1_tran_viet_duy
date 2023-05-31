package controller;

import service.IBookingService;
import service.impl.BookingService;

import java.util.Scanner;

public class BookingManagementController {
    private static Scanner scanner = new Scanner(System.in);
    private static IBookingService bookingService = new BookingService();


    public static void displayBookingMenu() {
        do {
            System.out.println("Please enter number from 1 to 4 to select service: ");
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new contracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    bookingService.addNewBooking();
                    break;
                case 2:
                    bookingService.displayListBooking();
                    break;
                case 3:
                    bookingService.createNewContract();
                    break;
                case 4:
                    bookingService.displayListContract();
                    break;
                case 5:
                    bookingService.editContract();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Wrong. It is not number format. Please try again");
            }
        } while(true);

    }
}
