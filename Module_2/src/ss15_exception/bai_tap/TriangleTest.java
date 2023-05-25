package ss15_exception.bai_tap;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        boolean check = false;
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                System.out.println("Vui lòng nhập vào giá trị của a:");
                int a = Integer.parseInt(scanner.nextLine());
                System.out.println("Vui lòng nhập vào giá trị của b:");
                int b = Integer.parseInt(scanner.nextLine());
                System.out.println("Vui lòng nhập vào giá trị của c:");
                int c = Integer.parseInt(scanner.nextLine());
                checkTriangleSide(a, b, c);
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Giá trị bạn nhập vào không phải định dạng số");
                check = true;
            } catch (IllegalTriangleException illegalTriangleException) {
                System.out.println(illegalTriangleException.getMessage());
                check = true;
            } catch (Exception e) {
                System.out.println("Error!!!");
                check = true;
            }

        } while (check);


    }

    public static boolean checkTriangleSide(int a, int b, int c) throws IllegalTriangleException {
        if (a + b <= c || b + c <= a || a + c <= b || a < 0 || b < 0 || c < 0) {
            throw new IllegalTriangleException("3 số nhập vào không phải là 3 cạnh của 1 tam giác");
        }
        return true;
    }
}
