package repository;

import model.Person.Employee;

import java.util.List;

public interface IRepository <T> {
    List<T> getAll();

    T getByCode(String Code);


    void addNew (T t);

    void deleteEmployee(T employeeCheck);
}
