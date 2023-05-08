package ss1_introduction_java.bai_tap.bai_2_ung_dung_doc_so_thanh_chu;

import java.util.Scanner;

public class MoneyExchange {
    public static void main(String[] args) {
        double rate = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your usd amount: ");
        double usd = scanner.nextDouble();
        double vnd = usd * rate;
        System.out.println("Your money exchange to VND is: " + vnd);
    }
}
