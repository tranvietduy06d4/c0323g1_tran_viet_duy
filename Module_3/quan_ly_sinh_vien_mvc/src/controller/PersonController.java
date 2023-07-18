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
            System.out.println("4. Lưu danh sách giảng viên hoặc học sinh sang file .csv");
            System.out.println("5. Thoát");
            System.out.println("Chọn chức năng:");
            int choice = -1;
            boolean check = false;
            do {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    check = false;

                } catch (NumberFormatException n) {
                    System.out.println("Giá trị bạn nhập vào không phải định dạng số. Vui lòng bấm số từ 1 đến 5 để thực hiện chức năng tương ứng");
                    check = true;
                } catch (Exception e) {
                    System.out.println("Sai. Vui lòng chọn lại");
                    check = true;
                }

                if (choice < 1 || choice > 5) {
                    check = true;
                }
            } while (check);


            switch (choice) {
                case 1:

                    int addChoice = -1;
                    boolean checkAddChoice = false;
                    do {
                        System.out.println("Vui lòng chọn: \n 1. Thêm mới giảng viên \n 2. Thêm mới học viên ");
                        try {
                            addChoice = Integer.parseInt(scanner.nextLine());
                            checkAddChoice = false;
                        } catch (NumberFormatException n) {
                            System.out.println("Giá trị bạn nhập vào không phải định dạng số.");
                            checkAddChoice = true;
                        } catch (Exception e) {
                            e.getStackTrace();
                            checkAddChoice = true;
                        }
                    } while (checkAddChoice);

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
                    int deleteChoice = -1;
                    boolean checkDeleteChoice = false;
                    do {
                        try {
                            deleteChoice = Integer.parseInt(scanner.nextLine());
                            checkDeleteChoice = false;
                        } catch (NumberFormatException n) {
                            System.out.println("Giá trị bạn nhập vào không phải định dạng số. Vui lòng chọn: \n 1. Xóa giảng viên \n 2. Xóa học viên");
                            checkDeleteChoice = true;
                        } catch (Exception e) {
                            e.getStackTrace();
                            checkDeleteChoice = true;
                        }
                    } while (checkDeleteChoice);

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
                    int displayChoice = -1;
                    boolean checkDisplayChoice = false;
                    do {
                        try {
                            displayChoice = Integer.parseInt(scanner.nextLine());

                            checkDisplayChoice = false;
                        } catch (NumberFormatException n) {
                            System.out.println("Giá trị bạn nhập vào không phải là số. Vui lòng nhập lại số 1 hoặc 2 để lựa chọn chức năng");
                            checkDisplayChoice = true;
                        }
                        if(displayChoice <1 || displayChoice>2) {
                            checkDisplayChoice = true;
                        }

                    } while (checkDisplayChoice);

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
                    System.out.println("Vui lòng chọn: \n 1. Lưu file danh sách giảng viên \n 2. Lưu file danh sách học viên ");
                    int exportChoice;
                    try {
                        exportChoice = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException n) {
                        throw new NumberFormatException();
                    }
                    switch (exportChoice) {
                        case 1:
                            teacherService.exportPersonListToFile();
                            break;

                        case 2:
                            studentService.exportPersonListToFile();
                            break;

                    }
                    break;

                case 5:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình. Hẹn gặp lại!");
                    System.exit(1);
                default:
                    System.out.println("Sai. Không có chức năng tương ứng. Vui lòng bấm số từ 1 đến 5 để thực hiện chức năng tương ứng");
            }

        } while (true);

    }
}