package service.impl;

import model.Person;
import model.Student;
import repository.IPersonRepository;
import repository.impl.StudentRepository;
import service.IPersonService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IPersonService {
    private static IPersonRepository studentRepository = new StudentRepository();

    @Override
    public void displayAll() {
        List<Person> studentList = studentRepository.getAll();
        for (Person p : studentList) {
            System.out.println(p);
        }
    }


    @Override
    public void addPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập vào số ID của Học viên: ");
        String idStudent = scanner.nextLine();

        Person checkId = studentRepository.getById(idStudent);
        if (checkId == null) {
            System.out.println("Vui lòng nhập tên:");
            String name = scanner.nextLine();
            System.out.println("Vui lòng nhập ngày sinh:");
            String birthDay = scanner.nextLine();
            System.out.println("Vui lòng nhập giới tính:(bấm 1 hoặc 2)\n 1.Nam \n 2.Nữ");
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
            System.out.println("Vui lòng nhập tên lớp:");
            String className = scanner.nextLine();
            System.out.println("Vui lòng nhập điểm số:");
            int score = Integer.parseInt(scanner.nextLine());

            Person newStudent = new Student(idStudent, name, birthDay, gender, className, score);
            studentRepository.addPerson(newStudent);
        } else {
            System.out.println("ID này đã tồn tại trên hệ thống nên không thể thêm mới");
        }

    }

    @Override
    public void deletePerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập vào id của Học viên cần xóa khỏi danh sách:");
        String idStudent = scanner.nextLine();
        Person checkId = studentRepository.getById(idStudent);
        if (checkId != null) {
            studentRepository.deletePerson(checkId);
        }

    }
}
