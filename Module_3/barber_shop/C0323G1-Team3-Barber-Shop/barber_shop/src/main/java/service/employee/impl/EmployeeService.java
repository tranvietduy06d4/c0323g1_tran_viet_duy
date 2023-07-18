package service.employee.impl;

import model.Account;
import model.Employee;
import repository.employee.IEmployeeRepository;
import repository.employee.impl.EmployeeRepository;
import service.employee.IEmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> display() {
        return employeeRepository.display();
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.create(employee);
    }

    @Override
    public void edit(Employee employee) {
        employeeRepository.edit(employee);

    }

    @Override
    public void remove(int id) {
        employeeRepository.remove(id);

    }

    @Override
    public int getEmployeeAccountId(String username) {
        return employeeRepository.getAccountId(username);
    }

    @Override
    public void insertAccount(Account account) {
        employeeRepository.insertAccount(account);
    }

    @Override
    public Employee getById(int employeeId) {
        return employeeRepository.getById(employeeId);
    }

}
