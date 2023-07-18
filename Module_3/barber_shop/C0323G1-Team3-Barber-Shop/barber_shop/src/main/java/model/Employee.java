package model;

import java.util.Objects;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String birthDay;
    private double salary;
    private String phoneNumber;
    private boolean gender;
    private String idCard;
    private String address;
    private int accountId;

    public Employee() {
    }

    public Employee(String employeeName, String birthDay, double salary, String phoneNumber, boolean gender, String idCard, String address, int accountId) {
        this.employeeName = employeeName;
        this.birthDay = birthDay;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.idCard = idCard;
        this.address = address;
        this.accountId = accountId;
    }

    public Employee(int employeeId, String employeeName, String birthDay, double salary, String phoneNumber, boolean gender, String idCard, String address, int accountId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthDay = birthDay;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.idCard = idCard;
        this.address = address;
        this.accountId = accountId;
    }

    public Employee(int employeeId, String employeeName, String birthDay, double salary, String phoneNumber, boolean gender, String idCard, String address) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthDay = birthDay;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.idCard = idCard;
        this.address = address;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", salary=" + salary +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", idCard='" + idCard + '\'' +
                ", address='" + address + '\'' +
                ", accountId=" + accountId +
                '}';
    }
}
