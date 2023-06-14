package bai_tap_them.excercise_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SecondMaxValue {
    public static void main(String[] args) {
        int [] integerArray = {8, 8, 8, 8, 8};
        int result = findIndexOfSecondMaxValue(integerArray);
        System.out.println(result);

    }

    public static int findIndexOfSecondMaxValue(int[] array) {
//        int maxFirst = array[0];
//        int maxSecond = array[0];
//        int index = -1;
//
//        for (int i = 0; i < array.length; i++) {
//            if(array[i] > maxFirst) {
//                maxFirst = array[i];
//            }
//        }
//
//        for (int i = array.length -1; i >=0; i--) {
//            if(array[i] > maxSecond && array[i] < maxFirst) {
//                maxSecond = array[i];
//                index = i;
//            }
//        }
//
//        return index;
        ArrayList<Integer> interArray = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < interArray.size(); j++) {
                if(array[i] == interArray.get(j)) {
                    flag = false;
                }
            }
            if(flag) {
                interArray.add(array[i]);
            }
        }
        int maxFirst;
        int maxSecond;
        int index = -1;

        Collections.sort(interArray);
        if(interArray.size() >= 2) {
            maxSecond = interArray.get(interArray.size()-2);
            for (int i = 0; i < array.length; i++) {
                if(array[i] == maxSecond) {
                    index = i;
                    break;
                }
            }
        }

        return index;
    }
}
