package repository.impl;

import model.Person;
import model.Student;
import repository.IPersonRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IPersonRepository {

    private static List<Person> studentList = new ArrayList<>();
    static {
        studentList.add(new Student("S-001","Nguyen Van A","20/10/1990",true,"C0323G1",9));
        studentList.add(new Student("S-002","Nguyen Van B","20/01/1989",true,"C0223G1",8));
        studentList.add(new Student("S-003","Nguyen Thi C","20/03/2000",false,"C0123G1",7));
    }


    @Override
    public List<Person> getAll() {
        return studentList;
    }

    @Override
    public void addPerson(Person person) {
        studentList.add(person);
    }

    @Override
    public void deletePerson(Person person) {
        studentList.remove(person);
    }

    @Override
    public Person getById(String id) {
        for (Person p: studentList) {
            if(p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}
