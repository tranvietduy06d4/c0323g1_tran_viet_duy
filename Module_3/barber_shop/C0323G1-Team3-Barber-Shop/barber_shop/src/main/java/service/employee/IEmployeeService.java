package service.employee;

import model.Account;
import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {
    public List<Employee> display();
    public void create(Employee employee);

    public void edit(Employee employee);

    public void remove(int id);
    int getEmployeeAccountId(String name);

    void insertAccount(Account account);
    Employee getById(int employeeId);
}
