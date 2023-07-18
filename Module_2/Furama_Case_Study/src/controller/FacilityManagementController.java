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
            System.out.println("3. Delete facility");
            System.out.println("4. Display list facility maintenance");
            System.out.println("5. Return main menu");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        facilityService.displayAll();
                        break;
                    case 2:
                        facilityService.addNew();
                        break;
                    case 3:
                        facilityService.delete();
                        break;
                    case 4:
                    facilityService.displayListFacilityMaintenance();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Wrong. You must press number from 1 to 5 to choose service. Please try again");
                }
            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not a number. Please try again");
            }

        } while (true);
    }
}
