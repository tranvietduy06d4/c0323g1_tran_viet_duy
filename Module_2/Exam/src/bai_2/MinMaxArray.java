package bai_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinMaxArray {
    public static void main(String[] args) {
        int[] array = {6, 2, 3, 8};
        int[] minMaxArray;
        int min;
        int max;
        if (array.length < 200) {
            minMaxArray = makeArrayConsecutive(array);
            System.out.println(Arrays.toString(minMaxArray));
        } else {
            System.out.println("Mảng nhập vào phải có số lượng phần tử nhỏ hơn 200. Vui lòng thử lại");
        }

    }

    public static int[] makeArrayConsecutive(int[] array) {
        ArrayList<Integer> integerList = new ArrayList<>();

        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        for (int i = min; i < max; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length; j++) {
                if (i == array[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                integerList.add(i);
            }
        }

        int[] consecutiveArray = new int[integerList.size()];
        for (int i = 0; i < consecutiveArray.length; i++) {
            consecutiveArray[i] = integerList.get(i);
        }
        return consecutiveArray;
    }
}
