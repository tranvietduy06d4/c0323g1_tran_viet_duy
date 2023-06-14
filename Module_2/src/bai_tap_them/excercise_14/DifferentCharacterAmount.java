package bai_tap_them.excercise_14;

import java.util.HashSet;
import java.util.Set;

public class DifferentCharacterAmount {
    public static void main(String[] args) {
        String string = "cabca";
        int result = calculateDifferentCharacter(string);
        System.out.println(result);

    }

    public static int calculateDifferentCharacter(String string) {
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            characterSet.add(string.charAt(i));
        }

        return characterSet.size();
    }
}
