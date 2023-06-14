package bai_tap_them.excercise_1;

import java.util.HashSet;
import java.util.Set;

public class EqualFrequencyCheck {

    public static void main(String[] args) {
        int[] integerArray = {1, 2, 2, 3, 1, 3, 1, 3};
        boolean result = checkFrequency(integerArray);
        System.out.println(result);

    }


    public static boolean checkFrequency(int[] integerArray) {
        Set<Integer> integerSet = new HashSet<>();
        int count = 0;
        for (int i = 0; i < integerArray.length; i++) {
            for (int j = 0; j < integerArray.length; j++) {
                if (integerArray[i] == integerArray[j]) {
                    count++;
                }
            }
            integerSet.add(count);
            count = 0;
        }

        if (integerSet.size() == 1) {
            return true;
        }
        return false;
    }
}
