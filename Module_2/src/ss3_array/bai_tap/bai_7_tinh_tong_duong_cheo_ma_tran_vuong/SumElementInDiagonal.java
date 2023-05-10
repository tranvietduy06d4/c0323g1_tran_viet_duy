package ss3_array.bai_tap.bai_7_tinh_tong_duong_cheo_ma_tran_vuong;

import java.util.Scanner;

public class SumElementInDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your array length: ");
        int arraySize = scanner.nextInt();
        double[][] array = new double[arraySize][arraySize];
        double sum = 0;
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                System.out.println("Please enter value of element " + i + ", " + j);
                array[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < array.length; i++) {
            sum += array[i][i];
        }
        System.out.println("The result is: " + sum);
    }
}
