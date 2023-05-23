package ss13_search_algorithms.bai_tap.bai_1_chuoi_tang_dan_do_dai_lon_nhat;

import java.util.LinkedList;
import java.util.Scanner;

public class LengthMaxString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập vào chuỗi kí tự cần kiểm tra: ");
        String string = scanner.nextLine();

        LinkedList<Character> maxString = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            LinkedList<Character> characterList = new LinkedList<>();
            characterList.add(string.charAt(i));

            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > characterList.getLast()) {
                    characterList.add(string.charAt(j));
                }
            }

            if (characterList.size() > maxString.size()) {
                maxString.clear();
                maxString.addAll(characterList);
            }
        }

        for (Character c : maxString) {
            System.out.println(c);
        }
    }
}
