package ss1_introduction_java.thuc_hanh;

import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        String daysInMonth;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập vào tháng cần kiểm tra: ");
        int month = scanner.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = "31";
                break;
            case 2:
                daysInMonth = "28 hoặc 29";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = "30";
                break;
            default:
                daysInMonth = "";
        }
        if (!daysInMonth.equals("")) {
            System.out.println("Tháng " + month + " có " + daysInMonth + " ngày");
        } else {
            System.out.println("Tháng này không có thực");
        }
    }
}
