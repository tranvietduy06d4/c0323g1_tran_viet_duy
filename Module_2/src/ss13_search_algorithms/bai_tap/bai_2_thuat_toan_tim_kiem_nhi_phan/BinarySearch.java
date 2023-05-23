package ss13_search_algorithms.bai_tap.bai_2_thuat_toan_tim_kiem_nhi_phan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập vào độ dài của mảng: ");
        int length = Integer.parseInt(scanner.nextLine());
        int[] integerArray = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println("Vui lòng nhập vào phần tử thứ " + i + "của mảng");
            integerArray[i] = Integer.parseInt(scanner.nextLine());
        }
        Arrays.sort(integerArray);
        System.out.println("Vui lòng nhập vào giá trị cần kiểm tra: ");
        int number = Integer.parseInt(scanner.nextLine());
        int result = binarySearch(integerArray, 0, integerArray.length, number);
        System.out.println(result);
    }

    public static int binarySearch(int[] integerArray, int first, int last, int number) {
        if (first < last) {
            int mid = (first + last) / 2;
            if (integerArray[mid] == number) {
                return mid;
            } else if (integerArray[mid] > number) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
            return binarySearch(integerArray, first, last, number);
        }
        return -1;
    }
}






