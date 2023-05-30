package ss18_string_and_regex.bai_tap.bai_1_validate_ten_lop;

import java.util.Scanner;

public class ClassNameTest {
    public static void main(String[] args) {
        String regexClassName = "^[C|A|P]\\d{4}[G|H|I|K]$";
        String className;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Vui lòng nhập vào tên class để check: ");
            className = scanner.nextLine();

        } while (!ClassNameValidate.validateClassName(className, regexClassName));
        System.out.println("Lớp bạn nhập vào hợp lệ");
    }
}
