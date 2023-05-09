package ss2_loop_statement.bai_tap.bai_2_hien_thi_20_so_nguyen_to;

import java.util.Scanner;

public class PrimeShow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter how many integer number that you want to display: ");
        int N = scanner.nextInt();
        int number = 2;
        int count = 0;
        while (count <= N) {
            boolean flag = true;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Your integer number is: " + number);
                count++;
            }
            number++;
        }
    }
}
