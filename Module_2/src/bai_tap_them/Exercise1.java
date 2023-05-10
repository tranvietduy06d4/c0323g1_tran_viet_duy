package bai_tap_them;

public class Exercise1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                if (j == -i || j == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 4; i >= 1; i--) {
            for (int j = -5; j <= 5; j++) {
                if (j == -i || j == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
