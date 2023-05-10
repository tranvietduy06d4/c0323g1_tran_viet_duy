package ss3_array.bai_tap.bai_3_gop_mang;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayConcat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the length of your array A: ");
        int arrayASize = scanner.nextInt();
        int[] arrayA = new int[arrayASize];
        for (int i = 0; i < arrayASize; i++) {
            System.out.println("Please enter value of element " + (i + 1));
            arrayA[i] = scanner.nextInt();
        }

        System.out.println("Please enter the length of your array B: ");
        int arrayBSize = scanner.nextInt();
        int[] arrayB = new int[arrayBSize];
        for (int i = 0; i < arrayBSize; i++) {
            System.out.println("Please enter value of element " + (i + 1));
            arrayB[i] = scanner.nextInt();
        }

        int arrayCSize = arrayASize + arrayBSize;
        int[] arrayC = new int[arrayCSize];

        for (int i = 0; i < arrayA.length; i++) {
            arrayC[i] = arrayA[i];
        }

        for (int i = 0, j = arrayA.length; i < arrayB.length; i++, j++) {
            arrayC[j] = arrayB[i];
        }

        System.out.println(Arrays.toString(arrayC));
    }
}
