package repository.impl;

import model.Person.Customer;
import model.Person.Employee;
import repository.ICustomerRepository;
import repository.IRepository;
import utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private List<Customer> customerList = new ArrayList<>();
    private static final String PATH_CUSTOMER = "src/data/customer_list.csv";
    @Override
    public List<Customer> getAll() {
        List<String> string = ReadAndWrite.readFile(PATH_CUSTOMER);
        customerList.clear();
        String[] info;
        for (String str:string) {
            info = str.split(",");
            customerList.add(new Customer(info[0],info[1],info[2],Boolean.parseBoolean(info[3]),info[4],info[5],info[6],info[7],info[8]));
        }
        return customerList;
    }

    @Override
    public Customer getByCode(String code) {
        customerList = getAll();
        for (Customer customer:customerList) {
            if(customer.getPersonCode().equals(code)) {
                return customer;
            }
        }
        return null;
    }


        @Override
    public void addNew(Customer customer) {
        List<String> string = new ArrayList<>();
        string.add(customer.getPersonCode()+","+customer.getPersonName()+","+customer.getBirthDay()+","+customer.isGender()+","+customer.getPersonId()+","+customer.getPhoneNumber()+","+customer.getEmail()+","+customer.getCustomerType()+","+customer.getCustomerAddress());
        ReadAndWrite.writeFile(PATH_CUSTOMER,string,true);
    }

    @Override
    public void delete(Customer customer) {
        customerList = getAll();
        customerList.remove(customer);
        List<String> string = new ArrayList<>();
        for (Customer c:customerList) {
            string.add(c.getPersonCode()+","+c.getPersonName()+","+c.getBirthDay()+","+c.isGender()+","+c.getPersonId()+","+c.getPhoneNumber()+","+c.getEmail()+","+c.getCustomerType()+","+c.getCustomerAddress());
        }
        ReadAndWrite.writeFile(PATH_CUSTOMER,string,false);

    }

//    public Customer(String personCode, String personName, String birthDay, boolean gender, String personId, String phoneNumber, String email, String customerType, String customerAddress) {

    @Override
    public void editCustomer() {
//        customerList = getAll();
        List<String> string = new ArrayList<>();
        for (Customer c:customerList) {
            string.add(c.getPersonCode()+","+c.getPersonName()+","+c.getBirthDay()+","+c.isGender()+","+c.getPersonId()+","+c.getPhoneNumber()+","+c.getEmail()+","+c.getCustomerType()+","+c.getCustomerAddress());
        }

        ReadAndWrite.writeFile(PATH_CUSTOMER,string,false);

    }

    @Override
    public List<Customer> getCustomerByName(String name) {
        customerList = getAll();
        List<Customer> customerSearchList = new ArrayList<>();
        for (Customer c: customerList) {
            if(c.getPersonName().contains(name)) {
                customerSearchList.add(c);
            }
        }
        if(!customerSearchList.isEmpty()) {
            return customerSearchList;
        } else {
            return null;
        }
    }
}
