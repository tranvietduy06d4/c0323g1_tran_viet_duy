package repository;

import model.Person.Employee;

import java.util.List;

public interface IEmployeeRepository extends IRepository <Employee> {
    public void editEmployee();

    public List<Employee> getEmployeeByName(String name);


}
