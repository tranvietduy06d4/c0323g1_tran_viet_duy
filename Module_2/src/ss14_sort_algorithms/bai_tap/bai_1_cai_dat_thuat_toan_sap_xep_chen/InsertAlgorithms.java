package ss14_sort_algorithms.bai_tap.bai_1_cai_dat_thuat_toan_sap_xep_chen;

import java.util.Arrays;

public class InsertAlgorithms {
    public static void main(String[] args) {
        int[] array = {7,2,5,9,4};
        insertIntegerArray(array);

    }

    public static void insertIntegerArray (int[] array) {
        int element;
        int position;
        for (int i = 1; i < array.length; i++) {
            element = array[i];
            position = i;
            while (position>0 && element < array[position-1]) {
                array[position] = array[position-1];
                position--;
            }
            array[position] = element;
        }
        System.out.println(Arrays.toString(array));
    }
}
