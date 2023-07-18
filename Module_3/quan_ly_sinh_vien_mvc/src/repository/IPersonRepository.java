package repository;

import model.Person;
import model.Student;
import model.Teacher;

import java.lang.annotation.ElementType;
import java.util.List;

public interface IPersonRepository {
    List<Person> getAll();

    void addPerson(Person person);

    void deletePerson(Person person);

    Person getById(String idStudent);

}
