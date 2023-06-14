package bai_tap_them.excercise_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CharacterCheck {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "adcaa";
        Integer result = countCharacter(s1, s2);
        System.out.println(result);

    }

    public static Integer countCharacter(String s1, String s2) {
        List<Character> characterList1 = new LinkedList<>();
        List<Character> characterList2 = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            characterList1.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            characterList2.add(s2.charAt(i));
        }
        for (int i = 0; i < characterList1.size(); i++) {
            for (int j = 0; j < characterList2.size(); j++) {
                if (characterList1.get(i) == characterList2.get(j)) {
                    characterList2.remove(characterList2.get(j));
                    count++;
                    break;
                }
            }
        }
        return count;

    }
}
