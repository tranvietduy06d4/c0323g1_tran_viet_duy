package controller;

import service.IEmployeeService;
import service.IService;
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
            System.out.println("4. Delete employee");
            System.out.println("5. Search employee by name");
            System.out.println("6. Return main menu");
            int choice = 0;
            try{
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not number format");
            } catch (Exception e) {
                System.out.println("Error!!!");
            }
            switch (choice) {
                case 1:
                    employeeService.displayAll();
                    break;
                case 2:
                    employeeService.addNew();
                    break;
                case 3:
                    employeeService.editEmployee();
                    break;
                case 4:
                    employeeService.delete();
                    break;
                case 5:
                    employeeService.getEmployeeByName();
                    break;
                case 6:
                    return;
//                default:
//                    System.out.println("Wrong. It is not number format. Please try again");
            }
        } while (true);

    }
}
