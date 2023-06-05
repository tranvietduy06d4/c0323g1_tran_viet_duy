package service.impl;

import model.Person.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;
import utils.AgeChecking;
import utils.Regex;

import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private static ICustomerRepository customerRepository = new CustomerRepository();
    private String nameRegex = "^(([A-Z][a-z]*)(\\s|$))+$";
    private String idRegex = "^(\\d{9}|\\d{12})$";
    private String phoneNumberRegex = "^[0]\\d{9}$";
    private String codeRegex = "^(KH-)\\d{4}$";

    private String birthDayRegex = "^(19|20)?[0-9]{2}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";
    private String emailRegex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    @Override
    public void displayAll() {
        List<Customer> customerList = customerRepository.getAll();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    //    public Customer(String personCode, String personName, String birthDay, boolean gender, String personId, String phoneNumber, String email, String customerType, String customerAddress) {
    @Override
    public void addNew() {
        Scanner scanner = new Scanner(System.in);

        String customerCode;
        do {
            System.out.println("Please enter Code of customer to add: ");
            customerCode = scanner.nextLine();
        } while (!Regex.checkCode(customerCode, codeRegex));


        Customer customerCheck = customerRepository.getByCode(customerCode);
        if (customerCheck == null) {

            String customerName;
            do {
                System.out.println("Please enter customer name: ");
                customerName = scanner.nextLine();
            } while (!Regex.checkName(customerName, nameRegex));


            String birthDay;
            do {
                System.out.println("Please enter birth day of customer: ");
                birthDay = scanner.nextLine();
            } while (!Regex.checkBirthDay(birthDay, birthDayRegex) || !AgeChecking.checkAge(birthDay));


            int choice = 0;
            boolean gender;

            GENDER_CHOICE:
            while (true) {
                System.out.println("Please enter gender of customer: \n" +
                        "Press 1. Male (True)\n" +
                        "Press 2. Female (False)\n");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            gender = true;
                            break GENDER_CHOICE;
                        case 2:
                            gender = false;
                            break GENDER_CHOICE;
                        default:
                            System.out.println("Wrong. Please try again.");
                    }
                } catch (NumberFormatException n) {
                    System.out.println("Wrong. It is NOT a NUMBER. Please try again");
                }
            }


            String id;
            do {
                System.out.println("Please enter Id of customer:");
                id = scanner.nextLine();
            } while (!Regex.checkId(id, idRegex));


            String phoneNumber;
            do {
                System.out.println("Please enter phone number of customer:");
                phoneNumber = scanner.nextLine();
            } while (!Regex.checkPhoneNumber(phoneNumber, phoneNumberRegex));


            String email;
            do {
                System.out.println("Please enter email of customer:");
                email = scanner.nextLine();
            } while (!Regex.checkEmail(email, emailRegex));


            int customerTypeChoice = 0;
            String customerType = "";

            TYPE_CHOICE:
            while (true) {
                System.out.println("Please enter type of customer:");
                System.out.println("Press 1. Diamond\n" +
                        "Press 2. Platinum\n" +
                        "Press 3. Gold\n" +
                        "Press 4. Silver\n" +
                        "Press 5. Member\n");
                try {
                    customerTypeChoice = Integer.parseInt(scanner.nextLine());
                    switch (customerTypeChoice) {
                        case 1:
                            customerType = "Diamond";
                            break TYPE_CHOICE;
                        case 2:
                            customerType = "Platinum";
                            break TYPE_CHOICE;
                        case 3:
                            customerType = "Gold";
                            break TYPE_CHOICE;
                        case 4:
                            customerType = "Silver";
                            break TYPE_CHOICE;
                        case 5:
                            customerType = "Member";
                            break TYPE_CHOICE;
                        default:
                            System.out.println("Wrong. Please try again");
                    }
                } catch (NumberFormatException n) {
                    System.out.println("Wrong. It is NOT a NUMBER");
                }
            }


            System.out.println("Please enter customer address:");
            String address = scanner.nextLine();

            Customer newCustomer = new Customer(customerCode, customerName, birthDay, gender, id, phoneNumber, email, customerType, address);
            customerRepository.addNew(newCustomer);
            System.out.println("Success. Finish add new customer\n");
        } else {
            System.out.println("Wrong. This customer code is available in our system. Please try again\n");
        }


    }

    @Override
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter customer code to delete:");
        String customerCode = scanner.nextLine();
        Customer customer = customerRepository.getByCode(customerCode);
        if (customer != null) {
            System.out.println("Do you really want to delete this customer account with customer code: " + customer.getPersonCode() + " name: " + customer.getPersonName());
            System.out.println("Press 1. Delete this customer account\n" +
                    "Press 2. Cancel\n");
            int choice;
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    customerRepository.delete(customer);
                    System.out.println("Success. Finish delete customer account");
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Wrong. Please try again");
            }

        } else {
            System.out.println("Wrong. Do not find this customer code in our system. Please try again");
        }

    }


    @Override
    public void editCustomer() {
        Scanner scanner = new Scanner(System.in);

        String customerCode;
        do {
            System.out.println("Please enter Code of customer to edit: ");
            customerCode = scanner.nextLine();
        } while (!Regex.checkCode(customerCode, codeRegex));

        Customer customer = customerRepository.getByCode(customerCode);
        if (customer != null) {

            String name;
            do {
                System.out.println("Please enter customer name: ");
                name = scanner.nextLine();
            } while (!Regex.checkName(name, nameRegex));


            String birthDay;
            do {
                System.out.println("Please enter birth day of customer: ");
                birthDay = scanner.nextLine();
            } while (!Regex.checkBirthDay(birthDay, birthDayRegex) || !AgeChecking.checkAge(birthDay));


            int choice = 0;
            while (choice != 1 || choice != 2) {
                System.out.println("Please enter gender of customer: \n" +
                        "Press 1. Male (True)\n" +
                        "Press 2. Female (False)\n");
                try {
                    choice = Integer.parseInt(scanner.nextLine());

                } catch (NumberFormatException n) {
                    System.out.println("Wrong. It is not a number. Please try again");
                }
            }

            boolean gender;
            if (choice == 1) {
                gender = true;
            } else {
                gender = false;
            }


            String id;
            do {
                System.out.println("Please enter Id of customer:");
                id = scanner.nextLine();
            } while (!Regex.checkId(id, idRegex));


            String phoneNumber;
            do {
                System.out.println("Please enter phone number of customer:");
                phoneNumber = scanner.nextLine();
            } while (!Regex.checkPhoneNumber(phoneNumber, phoneNumberRegex));


            String email;
            do {
                System.out.println("Please enter email of customer:");
                email = scanner.nextLine();
            } while (!Regex.checkEmail(email, emailRegex));


            int customerTypeChoice = 0;
            String customerType = "";
            while (customerTypeChoice < 1 || customerTypeChoice > 5) {
                System.out.println("Please enter type of customer:");
                System.out.println("Press 1. Diamond\n" +
                        "Press 2. Platinum\n" +
                        "Press 3. Gold\n" +
                        "Press 4. Silver\n" +
                        "Press 5. Member\n");
                try {
                    customerTypeChoice = Integer.parseInt(scanner.nextLine());
                    switch (customerTypeChoice) {
                        case 1:
                            customerType = "Diamond";
                            break;
                        case 2:
                            customerType = "Platinum";
                            break;
                        case 3:
                            customerType = "Gold";
                            break;
                        case 4:
                            customerType = "Silver";
                            break;
                        case 5:
                            customerType = "Member";
                            break;
                        default:
                            System.out.println("Wrong. Please try again");
                    }

                } catch (NumberFormatException n) {
                    System.out.println("Wrong. It is not a number");
                }
            }


            System.out.println("Please enter customer address:");
            String address = scanner.nextLine();

//    public Customer(String personCode, String personName, String birthDay, boolean gender, String personId, String phoneNumber, String email, String customerType, String customerAddress) {

            customer.setPersonName(name);
            customer.setBirthDay(birthDay);
            customer.setGender(gender);
            customer.setPersonId(id);
            customer.setPhoneNumber(phoneNumber);
            customer.setEmail(email);
            customer.setCustomerType(customerType);
            customer.setCustomerAddress(address);

            customerRepository.editCustomer();


            System.out.println("Success. Finish edit customer information");
        } else {
            System.out.println("Wrong. This customer code is not available in our system. Please try again");
        }
    }

    @Override
    public void getCustomerByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter customer name to check: ");
        String name = scanner.nextLine();
        List<Customer> customerList = customerRepository.getCustomerByName(name);

        if (customerList != null) {
            System.out.println(customerList);
        } else {
            System.out.println("We do not find this name in our system");
        }
    }
}
