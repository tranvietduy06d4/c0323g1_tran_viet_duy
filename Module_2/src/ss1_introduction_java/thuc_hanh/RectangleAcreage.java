package ss1_introduction_java.thuc_hanh;

import java.util.Scanner;

public class RectangleAcreage {
    public static void main(String[] args) {
        float weight;
        float height;
        float acreage;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter weight of rectangle: ");
        weight = scanner.nextFloat();
        System.out.println("Enter height of rectangle: ");
        height = scanner.nextFloat();
        acreage = weight * height;
        System.out.println("Acreage of rectangle is: " + acreage);
    }
}
