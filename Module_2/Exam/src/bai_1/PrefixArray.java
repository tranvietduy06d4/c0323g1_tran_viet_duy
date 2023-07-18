package bai_1;

import java.util.Arrays;

public class PrefixArray {
    public static void main(String[] args) {
        int[] array = {1,1,1};
        int[] prefixArray;
        if (array.length <= 100) {
            prefixArray = createPrefixArray(array);
            System.out.println(Arrays.toString(prefixArray));
        } else {
            System.out.println("Mảng của bạn nhập vào vượt quá 100 phần tử. Vui lòng thử lại");
        }

    }

    public static int[] createPrefixArray(int[] array) {
        int[] prefixArray = new int[array.length];
        prefixArray[0] = array[0];
        int temp;
        for (int i = 0; i < array.length; i++) {
            temp = 0;
            for (int j = 0; j <= i; j++) {
                temp += array[j];
            }
            prefixArray[i] = temp;
        }
        return prefixArray;
    }
}
