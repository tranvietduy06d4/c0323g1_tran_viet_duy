package ss3_array.bai_tap.bai_2_them_phan_tu_vao_mang;

import java.util.Arrays;
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
        System.out.println("Please enter your number to add: ");
        int number = scanner.nextInt();
        System.out.println("Please enter your index to add (position of your number in array): ");
        int index = scanner.nextInt();
        while (index < 0 || index > array.length - 1) {
            System.out.println("Wrong.Please enter again your index to add (position of your number in array): ");
            index = scanner.nextInt();
        }

        for (int i = array.length - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = number;
        System.out.println(Arrays.toString(array));
    }
}
