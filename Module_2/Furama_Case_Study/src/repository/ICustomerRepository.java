package repository;

import model.Person.Customer;

import java.util.List;

public interface ICustomerRepository extends IRepository<Customer>{
    void editCustomer();

    List<Customer> getCustomerByName(String name);
}
