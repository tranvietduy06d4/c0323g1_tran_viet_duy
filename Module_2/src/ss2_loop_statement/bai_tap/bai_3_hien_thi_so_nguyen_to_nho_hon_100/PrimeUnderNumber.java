package ss2_loop_statement.bai_tap.bai_3_hien_thi_so_nguyen_to_nho_hon_100;

import java.util.Scanner;

public class PrimeUnderNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter upper limit of your integer number: ");
        int N = scanner.nextInt();
        int number = 2;
        boolean flag;
        while (number < N) {
            flag = true;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Your integer number is: " + number);
            }
            number++;
        }
    }
}
