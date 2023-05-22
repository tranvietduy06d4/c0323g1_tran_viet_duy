package controller;

import service.IPersonService;
import service.impl.StudentService;
import service.impl.TeacherService;

import java.util.Scanner;

public class PersonController {
    private static Scanner scanner = new Scanner(System.in);
    private static IPersonService studentService = new StudentService();
    private static IPersonService teacherService = new TeacherService();


    public static void showMenu() {
        do {
            System.out.println("------------------------------------------");
            System.out.println("Chọn chức năng (theo số) để tiếp tục");
            System.out.println("1. Thêm mới giảng viên hoặc học sinh");
            System.out.println("2. Xóa giảng viên hoặc học sinh");
            System.out.println("3. Xem danh sách giảng viên hoặc học sinh");
            System.out.println("4. Thoát");
            System.out.println("Chọn chức năng:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Vui lòng chọn: \n 1. Thêm mới giảng viên \n 2. Thêm mới học viên ");
                    int addChoice = Integer.parseInt(scanner.nextLine());
                    switch (addChoice) {
                        case 1:
                            teacherService.addPerson();
                            break;
                        case 2:
                            studentService.addPerson();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Vui lòng chọn: \n 1. Xóa giảng viên \n 2. Xóa học viên ");
                    int deleteChoice = Integer.parseInt(scanner.nextLine());
                    switch (deleteChoice) {
                        case 1:
                            teacherService.deletePerson();
                            break;
                        case 2:
                            studentService.deletePerson();
                            break;
                    }
                case 3:
                    System.out.println("Vui lòng chọn: \n 1. Xem danh sách giảng viên \n 2. Xem danh sách học viên ");
                    int displayChoice = Integer.parseInt(scanner.nextLine());
                    switch (displayChoice) {
                        case 1:
                            teacherService.displayAll();
                            break;

                        case 2:
                            studentService.displayAll();
                            break;
                    }
                    break;

                case 4:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình. Hẹn gặp lại!");
                    System.exit(1);
            }

        } while (true);


    }
}
