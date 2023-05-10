package ss3_array.bai_tap.bai_6_tinh_tong_cac_phan_tu_cung_cot_trong_mang;

import java.util.Scanner;

public class SumElementOfColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your array length: ");
        int arraySize = scanner.nextInt();
        System.out.println("Please enter the length of your element in array: ");
        int elementSize = scanner.nextInt();
        double[][] array = new double[arraySize][elementSize];
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < elementSize; j++) {
                System.out.println("Please enter value of element " + i + ", " + j);
                array[i][j] = scanner.nextInt();
            }
        }
        double sum = 0;
        System.out.println("Please enter index of your column in array: ");
        int index = scanner.nextInt();
        while (index < 0 || index > elementSize - 1) {
            System.out.println("Wrong. Please enter again index of your column in array: ");
            index = scanner.nextInt();
        }
        for (int i = 0; i < array.length; i++) {
            sum += array[i][index];
        }
        System.out.println("Result is: " + sum);
    }
}
