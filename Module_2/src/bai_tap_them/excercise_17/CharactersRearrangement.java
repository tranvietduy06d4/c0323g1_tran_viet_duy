package bai_tap_them.excercise_17;

import java.util.*;

public class CharactersRearrangement {
    public static void main(String[] args) {
        String string1 = "aacd";
        String string2 = "cbad";
        boolean result = checkCharactersRearrangement(string1,string2);
        System.out.println(result);

    }

    public static boolean checkCharactersRearrangement (String string1,String string2) {
        String[] characterArray1 = string1.split("");
        String[] characterArray2 = string2.split("");

        Arrays.sort(characterArray1);
        Arrays.sort(characterArray2);

        System.out.println(Arrays.toString(characterArray1));
        System.out.println(Arrays.toString(characterArray2));

        boolean flag = true;
        for (int i = 0; i < characterArray1.length; i++) {
            if(!characterArray1[i].equals(characterArray2[i])) {
                flag = false;
                break;
            }
        }
        return flag;

    }
}
