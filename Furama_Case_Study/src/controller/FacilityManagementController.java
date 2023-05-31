package controller;


import service.IFacilityService;

import service.impl.FacilityService;

import java.util.Scanner;

public class FacilityManagementController {
    private static Scanner scanner = new Scanner(System.in);
    private static IFacilityService facilityService = new FacilityService();
    public static void displayFacilityMenu() {
        do {
            System.out.println("Please enter number from 1 to 4 to select service: ");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    facilityService.displayListFacility();
                    break;
                case 2:
                    facilityService.addNewFacility();
                    break;
                case 3:
                    facilityService.displayListFacilityMainternance();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong. It is not number format. Please try again");
            }
        } while (true);
    }
}
