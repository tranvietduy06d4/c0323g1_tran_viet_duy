package repository.impl;

import model.Person;
import model.Teacher;
import repository.IPersonRepository;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements IPersonRepository {
    private static List<Person> teacherList = new ArrayList<>();
    static {
        teacherList.add(new Teacher("T-001","Tran Van D","10/03/1981",true,"JavaScript"));
        teacherList.add(new Teacher("T-002","Tran Van E","11/04/1979",true,"PHP"));
        teacherList.add(new Teacher("T-003","Tran Thi H","12/05/1980",false,"Java"));
    }

    @Override
    public List getAll() {
        return teacherList;
    }

    @Override
    public void addPerson(Person person) {
        teacherList.add(person);

    }

    @Override
    public void deletePerson(Person person) {
        teacherList.remove(person);
    }

    @Override
    public Person getById(String idSTeacher) {
        for (Person p: teacherList) {
            if(p.getId().equals(idSTeacher)) {
                return p;
            }
        }
        return null;
    }
}
