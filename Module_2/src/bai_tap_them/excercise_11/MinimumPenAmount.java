package bai_tap_them.excercise_11;

import java.util.Scanner;

public class MinimumPenAmount {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int x = 3;
        int y = 2;
        int z = 11;
        int minimumPenAmount = calculateMinPenAmount(x, y, z);
        System.out.println(minimumPenAmount);

    }

    public static int calculateMinPenAmount(int x, int y, int z) {
        int promotionTime = z / (x + y);
        int penAmount = z % (x + y) + promotionTime * x;
        return penAmount;
    }
}
