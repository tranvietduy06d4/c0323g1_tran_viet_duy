package ss3_array.bai_tap.bai_4_tim_phan_tu_lon_nhat_mang_2_chieu;

import java.util.Scanner;

public class MaxElement {
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
        double max = array[0][0];
        int indexA = 0;
        int indexB = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    indexA = i;
                    indexB = j;
                }
            }
        }
        System.out.println("Max element in your array is: " + max);
        System.out.println("Index of max element in array is: " + indexA + ", " + indexB);
    }
}

