package bai_tap_them.excercise_16;

import java.util.Arrays;

public class prefixArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        int[] prefixArray = createPrefixArray(array);
        System.out.println(Arrays.toString(prefixArray));

    }

    public static int[] createPrefixArray(int[] array) {
        int[] prefixArray = new int[array.length];
        int element = 0;

        for (int i = 0; i < array.length; i++) {
            element += array[i];
            prefixArray[i] = element;

        }
        return prefixArray;
    }
}
