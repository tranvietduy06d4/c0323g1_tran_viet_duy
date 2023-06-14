package bai_tap_them.excercise_6;

import java.util.*;

public class CharacterArray {
    public static void main(String[] args) {
        String string = "abcbdcef";
        List<Character> characterList = findCharacterArray(string);
        System.out.println(characterList);
    }

    public static List<Character> findCharacterArray(String string) {
        List<Character> characterList = new ArrayList<>();
        Set<Character> stringSet = new HashSet<>();
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(j) == string.charAt(i)) {
                    count++;
                }
            }
            if (count >= 2) {
                stringSet.add(string.charAt(i));
            }
            count = 0;
        }
        for (Character c : stringSet) {
            characterList.add(c);
        }
        return characterList;

    }
}
