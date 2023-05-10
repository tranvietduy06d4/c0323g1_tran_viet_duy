package ss3_array.bai_tap.bai_8_dem_so_lan_lap_ki_tu_trong_chuoi;

import java.util.Scanner;

public class CharCounting {
    public static void main(String[] args) {
        String string = "divenoixalam";
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your character to check: ");
        char character = scanner.next().charAt(0);
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == character) {
                count++;
            }
        }
        System.out.println("Result is: " + count);
    }
}
