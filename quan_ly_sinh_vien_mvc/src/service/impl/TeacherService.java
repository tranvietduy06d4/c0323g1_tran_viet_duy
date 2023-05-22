package service.impl;

import model.Person;
import model.Teacher;
import repository.IPersonRepository;
import repository.impl.StudentRepository;
import repository.impl.TeacherRepository;
import service.IPersonService;

import java.util.List;
import java.util.Scanner;

public class TeacherService implements IPersonService {
    private static IPersonRepository teacherRepository = new TeacherRepository();

    @Override
    public void displayAll() {
        List<Person> teacherList = teacherRepository.getAll();
        for (Person p: teacherList) {
            System.out.println(p);
        }
    }

    @Override
    public void addPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập vào mã số Giảng viên: ");
        String idTeacher = scanner.nextLine();
        Person checkId = teacherRepository.getById(idTeacher);
        if(checkId == null) {
            System.out.println("Vui lòng nhập Họ và tên của Giảng viên: ");
            String name = scanner.nextLine();
            System.out.println("Vui lòng nhập Ngày sinh của Giảng viên: ");
            String birthDay = scanner.nextLine();
            System.out.println("Vui lòng nhập vào Giới tính của Giảng viên:\n 1.Nam \n 2.Nữ");
            int choice = Integer.parseInt(scanner.nextLine());
            boolean gender = true;
            switch (choice) {
                case 1:
                    gender = true;
                    break;
                case 2:
                    gender = false;
                    break;
            }
            System.out.println("Vui lòng nhập Chuyên môn của Giảng viên: ");
            String speciality = scanner.nextLine();
            Person newTeacher = new Teacher(idTeacher,name,birthDay,gender,speciality);
            teacherRepository.addPerson(newTeacher);
        } else {
            System.out.println("Mã ID này đã tồn tại trên hệ thống nên không thể thêm mới được.");
        }
    }

    @Override
    public void deletePerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập vào ID của giảng viên cần xóa:");
        String idTeacher = scanner.nextLine();
        Person checkId = teacherRepository.getById(idTeacher);
        if(checkId != null) {
            teacherRepository.deletePerson(checkId);
        }
    }
}
