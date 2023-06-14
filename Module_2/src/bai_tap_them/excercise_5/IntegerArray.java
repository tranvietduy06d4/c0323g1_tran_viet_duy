package bai_tap_them.excercise_5;

import java.util.Arrays;

public class IntegerArray {
    public static void main(String[] args) {
        int[] integerArray = {-1, 150, 190, 170, -1, -1, 160, 180};
        int[] newArray = sortIntegerArray(integerArray);
        System.out.println(Arrays.toString(newArray));

    }

    public static int[] sortIntegerArray(int[] integerArray) {
        int temp;
        for (int i = 0; i < integerArray.length; i++) {
            for (int j = 0; j < integerArray.length; j++) {
                if (integerArray[i] != -1 && integerArray[j] > integerArray[i]) {
                    temp = integerArray[i];
                    integerArray[i] = integerArray[j];
                    integerArray[j] = temp;
                }
            }
        }
        return integerArray;
    }
}
