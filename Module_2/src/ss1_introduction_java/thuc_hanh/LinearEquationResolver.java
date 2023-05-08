package ss1_introduction_java.thuc_hanh;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        double x;
        System.out.println("Chương trình tìm nghiệm phương trình bậc nhất");
        System.out.println("Phương trình bậc nhất có dạng a*x + b = c");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập vào giá trị của a = ");
        double a = scanner.nextDouble();
        System.out.println("Vui lòng nhập vào giá trị của b = ");
        double b = scanner.nextDouble();
        System.out.println("Vui lòng nhập vào giá trị của c = ");
        double c = scanner.nextDouble();
        if (a != 0) {
            x = (c - b) / a;
            System.out.println("Phương trình có nghiệm duy nhất là x = " + x);
        } else if (b == c) {
            System.out.println("Phương trình có vô số nghiệm");
        } else {
            System.out.println("Phương trình vô nghiệm");
        }
    }
}
