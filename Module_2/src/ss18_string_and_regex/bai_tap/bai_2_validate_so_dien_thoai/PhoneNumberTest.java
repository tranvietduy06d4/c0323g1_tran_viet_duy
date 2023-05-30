package ss18_string_and_regex.bai_tap.bai_2_validate_so_dien_thoai;

import java.sql.SQLOutput;
import java.util.Scanner;

public class PhoneNumberTest {
    public static void main(String[] args) {
        String regexPhoneNumber = "(84)(-)\\d{10}";
        String phoneNumber;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Vui lòng nhập vào số điện thoại để check: ");
            phoneNumber = scanner.nextLine();
        } while (!PhoneNumber.validatePhoneNumber(phoneNumber,regexPhoneNumber));
        System.out.println("Số điện thoại bạn nhập vào hợp lệ");
    }
}
