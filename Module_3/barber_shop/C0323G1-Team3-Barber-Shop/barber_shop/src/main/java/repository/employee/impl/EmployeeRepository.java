package repository.employee.impl;

import model.Account;
import model.Employee;
import repository.DB_connect.BaseRepository;
import repository.employee.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String CALL_SELECT_ALL = " call display_all() ";
    private static final String INSERT_EMPLOYEE = " call add_employee(?,?,?,?,?,?,?,?) ";
    private static final String CALL_EDIT = "call edit_employee(?,?,?,?,?,?,?,?)";
    private static final String CALL_DELETE = "call delete_employee(?)";
    private static final String GET_BY_ID = "SELECT employee_name,birthday,salary,phone_number,gender,id_card,address FROM employee WHERE employee_id = ?";
    private static final String SELECT_ACCOUNT_ID = "select account_id " +
            "from account " +
            " where username = ? ;";
    private static final String INSERT_ACCOUNT = "INSERT INTO account(username,password,role_id) values(?,?,2);";

    @Override
    public List<Employee> display() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(CALL_SELECT_ALL);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("birthday");
                double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                boolean gender = resultSet.getBoolean("gender");
                String idCard = resultSet.getString("id_card");
                String address = resultSet.getString("address");
                int accountId = resultSet.getInt("account_id");
                employeeList.add(new Employee(id, name, birthday, salary, phoneNumber, gender, idCard, address, accountId));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(employeeList);
        return employeeList;
    }

//    public Employee(String employeeName, String birthDay, double salary, String phoneNumber, boolean gender,
//    String startDate, String idCard, String address, boolean employeeStatus, int accountId) {

    @Override
    public void create(Employee employee) {
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(INSERT_EMPLOYEE);
            callableStatement.setString(1, employee.getEmployeeName());
            callableStatement.setString(2, employee.getBirthDay());
            callableStatement.setDouble(3, employee.getSalary());
            callableStatement.setString(4, employee.getPhoneNumber());
            callableStatement.setBoolean(5, employee.isGender());
            callableStatement.setString(6, employee.getIdCard());
            callableStatement.setString(7, employee.getAddress());
            callableStatement.setInt(8, employee.getAccountId());
            callableStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public int getAccountId(String username) {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement;
        int accountId = 0;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_ID);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                accountId = resultSet.getInt("account_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountId;
    }

    @Override
    public void insertAccount(Account account) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(INSERT_ACCOUNT);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//    employee_name,birthday,salary,phone_number,gender,id_card,address
    @Override
    public Employee getById(int employeeId) {
        Connection connection = BaseRepository.getConnection();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID);
            preparedStatement.setInt(1,employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String employeeName = resultSet.getString("employee_name");
                String birthday = resultSet.getString("birthday");
                double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                boolean gender = resultSet.getBoolean("gender");
                String idCard = resultSet.getString("id_card");
                String address = resultSet.getString("address");
                employee = new Employee(employeeId,employeeName,birthday,salary,phoneNumber,gender,idCard,address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    @Override
    public void edit(Employee employee) {
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(CALL_EDIT);
            callableStatement.setInt(1,employee.getEmployeeId());
            callableStatement.setString(2,employee.getEmployeeName());
            callableStatement.setString(3,employee.getBirthDay());
            callableStatement.setDouble(4,employee.getSalary());
            callableStatement.setString(5,employee.getPhoneNumber());
            callableStatement.setBoolean(6,employee.isGender());
            callableStatement.setString(7,employee.getIdCard());
            callableStatement.setString(8,employee.getAddress());
            callableStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void remove(int id) {
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(CALL_DELETE);
            callableStatement.setInt(1,id);
            callableStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
