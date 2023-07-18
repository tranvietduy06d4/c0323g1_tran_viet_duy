package repository.employee;

import model.Account;
import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeRepository {
    public List<Employee> display();
    public void create(Employee employee);

    public void edit(Employee employee);

    public void remove(int id);
    int getAccountId(String name);

    void insertAccount(Account account);

    Employee getById(int employeeId);
}
