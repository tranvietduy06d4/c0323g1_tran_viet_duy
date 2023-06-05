package service.impl;

import model.Person.Employee;
import repository.IEmployeeRepository;
import repository.IRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;
import service.IService;
import utils.AgeChecking;
import utils.Regex;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static IEmployeeRepository employeeRepository = new EmployeeRepository();
    private String nameRegex = "^(([A-Z][a-z]*)(\\s|$))+$";
    private String idRegex = "^(\\d{9}|\\d{12})$";
    private String phoneNumberRegex = "^[0]\\d{9}$";
    private String codeRegex = "^(NV-)\\d{4}$";

    private String birthDayRegex = "^(19|20)?[0-9]{2}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";
    private String emailRegex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    @Override
    public void displayAll() {
        List<Employee> employeeList = employeeRepository.getAll();
        for (Employee e : employeeList) {
            System.out.println(e);
        }

    }
//        public Employee(String personCode, String personName, String birthDay, boolean gender, int personId, int phoneNumber, String email, String level, String position, int salary)

    @Override
    public void addNew() {
        Scanner scanner = new Scanner(System.in);
        String employeeCode;

        do {
            System.out.println("Please enter Code of employee to add: ");
            employeeCode = scanner.nextLine();
        } while (!Regex.checkCode(employeeCode, codeRegex));

        Employee employeeCheck = employeeRepository.getByCode(employeeCode);
        if (employeeCheck == null) {
            String employeeName;
            do {
                System.out.println("Please enter employee name: ");
                employeeName = scanner.nextLine();
            } while (!Regex.checkName(employeeName, nameRegex));


            String birthDay;
            do {
                System.out.println("Please enter birth day of employee: ");
                birthDay = scanner.nextLine();
            } while (!Regex.checkBirthDay(birthDay, birthDayRegex) || !AgeChecking.checkAge(birthDay));


            int choice = 0;
            while (choice != 1 || choice != 2) {
                System.out.println("Please enter gender of employee: \n" +
                        "Press 1. Male (True)\n" +
                        "Press 2. Female");
                choice = Integer.parseInt(scanner.nextLine());
            }

            boolean gender;
            if (choice == 1) {
                gender = true;
            } else {
                gender = false;
            }

            String employeeId;
            do {
                System.out.println("Please enter Id of employee:");
                employeeId = scanner.nextLine();
            } while (!Regex.checkId(employeeId, idRegex));

            String phoneNumber;
            do {
                System.out.println("Please enter phone number of employee:");
                phoneNumber = scanner.nextLine();
            } while (!Regex.checkPhoneNumber(phoneNumber, phoneNumberRegex));

            String email;
            do {
                System.out.println("Please enter email of employee:");
                email = scanner.nextLine();
            } while (!Regex.checkEmail(email, emailRegex));


            int levelChoice = 0;
            String level = "";
            while (levelChoice < 1 || levelChoice > 4) {
                System.out.println("Please enter level of employee:");
                System.out.println("Press 1. Intermediate\n" +
                        "Press 2. College\n" +
                        "Press 3. University\n" +
                        "Press 4. Postgraduate\n");
                levelChoice = Integer.parseInt(scanner.nextLine());
                switch (levelChoice) {
                    case 1:
                        level = "Intermediate";
                        break;
                    case 2:
                        level = "College";
                        break;
                    case 3:
                        level = "University";
                        break;
                    case 4:
                        level = "Postgraduate";
                        break;
                }
            }


            int positionChoice = 0;
            String position = "";
            while (positionChoice < 1 || positionChoice > 6) {
                System.out.println("Please enter position of employee:");
                System.out.println("Press 1. Receptionist\n" +
                        "Press 2. Service staff\n" +
                        "Press 3. Specialist\n" +
                        "Press 4. Supervisor\n" +
                        "Press 5. Manager\n" +
                        "Press 6. Director\n");
                positionChoice = Integer.parseInt(scanner.nextLine());
                switch (positionChoice) {
                    case 1:
                        position = "Receptionist";
                        break;
                    case 2:
                        position = "Service staff";
                        break;
                    case 3:
                        position = "Specialist";
                        break;
                    case 4:
                        position = "Supervisor";
                        break;
                    case 5:
                        position = "Manager";
                        break;
                    case 6:
                        position = "Director";
                        break;
                }
            }

            System.out.println("Please enter salary of employee:");
            float salary = Float.parseFloat(scanner.nextLine());
            while (salary <= 0 || salary > Float.MAX_VALUE) {
                System.out.println("Wrong. Please enter salary of employee again:");
                salary = Float.parseFloat(scanner.nextLine());
            }

            Employee employee = new Employee(employeeCode, employeeName, birthDay, gender, employeeId, phoneNumber, email, level, position, salary);
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
        if (employeeCheck != null) {
            System.out.println("Do you really want to delete this employee account with employee code: " + employeeCheck.getPersonCode() + " with name: " + employeeCheck.getPersonName());
            System.out.println("Please press following number to:\n" +
                    "1. Delete this employee account\n" +
                    "2. Cancel\n");
            int choice = 0;
            do {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException n) {
                    System.out.println("Wrong. It is not a number");
                } catch (Exception e) {
                    System.out.println("Error!!!");
                }
            } while (true);

            switch (choice) {
                case 1:
                    employeeRepository.delete(employeeCheck);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Wrong. Please try again");
            }


        }
    }

    @Override
    public void editEmployee() {

        Scanner scanner = new Scanner(System.in);

        String employeeCode;
        do {
            System.out.println("Please enter Code of employee to edit: ");
            employeeCode = scanner.nextLine();
        } while (!Regex.checkCode(employeeCode, codeRegex));

        Employee employee = employeeRepository.getByCode(employeeCode);
        if (employee != null) {
//    public Employee(String personCode, String personName, String birthDay, boolean gender, String personId, String phoneNumber, String email, String level, String position, float salary) {


            String name;
            do {
                System.out.println("Please enter new employee name: ");
                name = scanner.nextLine();
            } while (!Regex.checkName(name, nameRegex));



            String birthDay;
            do {
                System.out.println("Please enter birth day of employee: ");
                birthDay = scanner.nextLine();
            } while (!Regex.checkBirthDay(birthDay, birthDayRegex) || !AgeChecking.checkAge(birthDay));

            int choice = 0;
            while (choice != 1 || choice != 2) {
                System.out.println("Please enter gender of employee: \n" +
                        "Press 1. Male (True)\n" +
                        "Press 2. Female");
                choice = Integer.parseInt(scanner.nextLine());
            }

            boolean gender;
            if (choice == 1) {
                gender = true;
            } else {
                gender = false;
            }


            String employeeId;
            do {
                System.out.println("Please enter Id of employee:");
                employeeId = scanner.nextLine();
            } while (!Regex.checkId(employeeId, idRegex));


            String phoneNumber;
            do {
                System.out.println("Please enter phone number of employee:");
                phoneNumber = scanner.nextLine();
            } while (!Regex.checkPhoneNumber(phoneNumber, phoneNumberRegex));


            String email;
            do {
                System.out.println("Please enter email of employee:");
                email = scanner.nextLine();
            } while (!Regex.checkEmail(email, emailRegex));


            int levelChoice = 0;
            String level = "";
            while (levelChoice < 1 || levelChoice > 4) {
                System.out.println("Please enter level of employee:");
                System.out.println("Press 1. Intermediate\n" +
                        "Press 2. College\n" +
                        "Press 3. University\n" +
                        "Press 4. Postgraduate\n");
                levelChoice = Integer.parseInt(scanner.nextLine());
                switch (levelChoice) {
                    case 1:
                        level = "Intermediate";
                        break;
                    case 2:
                        level = "College";
                        break;
                    case 3:
                        level = "University";
                        break;
                    case 4:
                        level = "Postgraduate";
                        break;
                }
            }


            int positionChoice = 0;
            String position = "";
            while (positionChoice < 1 || positionChoice > 6) {
                System.out.println("Please enter position of employee:");
                System.out.println("Press 1. Receptionist\n" +
                        "Press 2. Service staff\n" +
                        "Press 3. Specialist\n" +
                        "Press 4. Supervisor\n" +
                        "Press 5. Manager\n" +
                        "Press 6. Director\n");
                positionChoice = Integer.parseInt(scanner.nextLine());
                switch (positionChoice) {
                    case 1:
                        position = "Receptionist";
                        break;
                    case 2:
                        position = "Service staff";
                        break;
                    case 3:
                        position = "Specialist";
                        break;
                    case 4:
                        position = "Supervisor";
                        break;
                    case 5:
                        position = "Manager";
                        break;
                    case 6:
                        position = "Director";
                        break;
                }
            }


            System.out.println("Please enter employee salary:");
            float salary = Float.parseFloat(scanner.nextLine());
            while (salary <= 0 || salary > Float.MAX_VALUE) {
                System.out.println("Wrong. Please enter salary of employee again:");
                salary = Float.parseFloat(scanner.nextLine());
            }

            employee.setPersonName(name);
            employee.setBirthDay(birthDay);
            employee.setGender(gender);
            employee.setPersonId(employeeId);
            employee.setPhoneNumber(phoneNumber);
            employee.setEmail(email);
            employee.setLevel(level);
            employee.setPosition(position);
            employee.setSalary(salary);
            System.out.println("Success. You finish edit employee");

        } else {
            System.out.println("Your employee code is not available in our system. Please try again");

        }
        employeeRepository.editEmployee();
    }

    @Override
    public void getEmployeeByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter employee name to check:");
        String name = scanner.nextLine();
        List<Employee> employeeList = employeeRepository.getEmployeeByName(name);
        if (employeeList != null) {
            System.out.println(employeeList);
        } else {
            System.out.println("We do not find this name in our system");

        }

    }
}
