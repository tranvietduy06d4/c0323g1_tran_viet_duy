package ss3_array.bai_tap.bai_1_xoa_phan_tu_khoi_mang;

import java.util.Arrays;
import java.util.Scanner;

public class ElementDeletion {
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


        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = 0;
                i--;
            }
        }


        System.out.println(Arrays.toString(array));

    }
}
