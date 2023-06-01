package service.impl;

import model.Person.Employee;
import repository.IRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;
import service.IService;

import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static IRepository<Employee> employeeRepository = new EmployeeRepository();
    @Override
    public void displayAll() {
        List<Employee> employeeList = employeeRepository.getAll();
        for (Employee e:employeeList) {
            System.out.println(e);
        }

    }
//        public Employee(String personCode, String personName, String birthDay, boolean gender, int personId, int phoneNumber, String email, String level, String position, int salary)

    @Override
    public void addNew() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Code of employee to add: ");
        String employeeCode = scanner.nextLine();
        Employee employeeCheck = employeeRepository.getByCode(employeeCode);
        if(employeeCheck == null) {
            System.out.println("Please enter employee name: ");
            String employeeName = scanner.nextLine();

            System.out.println("Please enter birth day of employee: ");
            String birthDay = scanner.nextLine();

            System.out.println("Please enter gender of employee: ");
            boolean gender  = Boolean.parseBoolean(scanner.nextLine());

            System.out.println("Please enter Id of employee:");
            String employeeId = scanner.nextLine();

            System.out.println("Please enter phone number of employee:");
            String phoneNumber = scanner.nextLine();

            System.out.println("Please enter email of employee:");
            String email = scanner.nextLine();

            System.out.println("Please enter level of employee:");
            String level = scanner.nextLine();

            System.out.println("Please enter position of employee:");
            String position = scanner.nextLine();

            System.out.println("Please enter salary of employee:");
            float salary = Float.parseFloat(scanner.nextLine());

            Employee employee = new Employee(employeeCode,employeeName,birthDay,gender,employeeId,phoneNumber,email,level,position,salary);
            employeeRepository.addNew(employee);
            System.out.println("Success. Finish adding new employee");
        } else {
            System.out.println("Wrong. That code is available in system. Try again");
        }

    }

    @Override
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Code of employee to add: ");
        String employeeCode = scanner.nextLine();
        Employee employeeCheck = employeeRepository.getByCode(employeeCode);
        if(employeeCheck != null) {
            employeeRepository.deleteEmployee(employeeCheck);
        }
    }

    @Override
    public void editEmployee() {
        ////
    }
}
