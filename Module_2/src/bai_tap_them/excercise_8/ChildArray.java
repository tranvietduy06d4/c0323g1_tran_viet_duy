package bai_tap_them.excercise_8;

import java.util.*;

public class ChildArray {
    public static void main(String[] args) {
        int[] arrayParent = {1, 4, 5, 2, 3, 2, 3, 1};
        int[] arrayChild = {1, 2, 3};
        int result = findAppearTime(arrayParent, arrayChild);
        System.out.println(result);

    }

    public static Integer findAppearTime(int[] arrayParent, int[] arrayChild) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        List<Integer> integerList = new ArrayList<>();
        int appearTime = 0;
        int count;
        for (int i = 0; i < arrayChild.length; i++) {
            count = 0;
            for (int j = 0; j < arrayParent.length; j++) {
                if (arrayParent[j] == arrayChild[i]) {
                    count++;
                }
            }
            if (count >= 1) {
                integerMap.put(arrayChild[i], count);
            }
        }

        if (integerMap.size() == arrayChild.length) {

            Set<Integer> integerSet = integerMap.keySet();
            for (Integer integer : integerSet) {
                integerList.add(integerMap.get(integer));
            }
            Collections.sort(integerList);
            appearTime = integerList.get(0);
        }

        return appearTime;
    }
}
