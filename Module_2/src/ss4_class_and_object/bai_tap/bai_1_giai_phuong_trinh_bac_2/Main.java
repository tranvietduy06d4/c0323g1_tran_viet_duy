package ss4_class_and_object.bai_tap.bai_1_giai_phuong_trinh_bac_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter value of a = ");
        double a = scanner.nextDouble();
        while (a == 0) {
            System.out.println("Wrong. Value of a must different 0. Please enter again value of a = ");
            a = scanner.nextDouble();
        }
        System.out.println("Please enter value of b = ");
        double b = scanner.nextDouble();
        System.out.println("Please enter value of c = ");
        double c = scanner.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        double delta = quadraticEquation.getDiscriminant();
        double result1 = quadraticEquation.getRoot1();
        double result2 = quadraticEquation.getRoot2();
        if (delta > 0) {
            System.out.println("We have 2 result: " + result1 + " and " + result2);
        } else if (delta == 0) {
            System.out.println("We have 1 result: " + result1);
        } else {
            System.out.println("We do not have any result");
        }
    }
}
