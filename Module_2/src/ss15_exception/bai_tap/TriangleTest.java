package ss15_exception.bai_tap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        boolean check = false;
        Scanner scanner = new Scanner(System.in);
        int a;
        int b;
        int c;

        do {
            System.out.println("Vui lòng nhập vào giá trị của a:");
            try {
                a = Integer.parseInt(scanner.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Giá trị bạn nhập vào không phải định dạng số. Vui lòng thử lại");
                check = true;
            } catch (InputMismatchException i) {
                System.out.println("Nhập sai định dạng số nguyên dương. Vui lòng thử lại ");
                check = true;
            } catch (Exception e) {
                System.out.println("Lỗi. Vui lòng thử lại");
                check = true;
            }
            if (a <= 0) {
                System.out.println("Sai. Lưu ý a phải là số nguyên dương");
                check = true;
            }

        } while (check);

        do {
            System.out.println("Vui lòng nhập vào giá trị của b:");
            try {
                b = Integer.parseInt(scanner.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Giá trị bạn nhập vào không phải định dạng số. Vui lòng thử lại");
                check = true;
            } catch (InputMismatchException i) {
                System.out.println("Nhập sai định dạng số nguyên dương. Vui lòng thử lại ");
                check = true;
            } catch (Exception e) {
                System.out.println("Lỗi. Vui lòng thử lại");
                check = true;
            }
            if (b <= 0) {
                System.out.println("Sai. Lưu ý a phải là số nguyên dương");
                check = true;
            }
        } while (check);

        do {
            System.out.println("Vui lòng nhập vào giá trị của c:");
            try {
                c = Integer.parseInt(scanner.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Giá trị bạn nhập vào không phải định dạng số. Vui lòng thử lại");
                check = true;
            } catch (InputMismatchException i) {
                System.out.println("Nhập sai định dạng số nguyên dương. Vui lòng thử lại ");
                check = true;
            } catch (Exception e) {
                System.out.println("Lỗi. Vui lòng thử lại");
                check = true;
            }
            if (c <= 0) {
                System.out.println("Sai. Lưu ý a phải là số nguyên dương");
                check = true;
            }
        } while (check);


        try {
            checkTriangleSide(a, b, c);
        } catch (IllegalTriangleException illegalTriangleException) {
            System.out.println(illegalTriangleException.getMessage());
        } catch (Exception e) {
            System.out.println("Error!!!");
        }

    }


    public static boolean checkTriangleSide(int a, int b, int c) throws IllegalTriangleException {
        if (a + b <= c || b + c <= a || a + c <= b) {
            throw new IllegalTriangleException("3 số nhập vào không phải là 3 cạnh của 1 tam giác");
        }
        return true;
    }
}
