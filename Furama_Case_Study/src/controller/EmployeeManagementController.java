package controller;

import service.IEmployeeService;
import service.impl.EmployeeService;

import java.util.Scanner;

public class EmployeeManagementController {
    private static Scanner scanner = new Scanner(System.in);
    private static IEmployeeService employeeService = new EmployeeService();

    public static void displayEmployeeMenu() {
        do {
            System.out.println("Please enter number from 1 to 4 to select service: ");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return main menu");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employeeService.displayListEmployee();
                    break;
                case 2:
                    employeeService.addNewEmployee();
                    break;
                case 3:
                    employeeService.editEmployee();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong. It is not number format. Please try again");
            }
        } while (true);

    }
}
