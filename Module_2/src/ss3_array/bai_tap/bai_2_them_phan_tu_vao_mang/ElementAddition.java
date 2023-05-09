package ss3_array.bai_tap.bai_2_them_phan_tu_vao_mang;

import java.util.Scanner;

public class ElementAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the length of your array: ");
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            System.out.println("Please enter value of element " + (i + 1));
            array[i] = scanner.nextInt();
        }
        System.out.println("Please your number to check. If it available in array, it will be deleted: ");
        int number = scanner.nextInt();
    }
}
