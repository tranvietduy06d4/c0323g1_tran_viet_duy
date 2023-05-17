package ss8_clean_code.bai_tap.bai_tap_1_tennis;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TennisGame firstSet = new TennisGame();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter player 1 score: ");
        int player1Score = scanner.nextInt();
        System.out.println("Please enter player 2 score: ");
        int player2Score = scanner.nextInt();
        String result;
        if (player1Score == player2Score) {
            result = firstSet.getScoreDeuce(player1Score);
        } else if (player1Score >= 4 || player2Score >= 4) {
            result = firstSet.getScoreAfterDeuce(player1Score, player2Score);
        } else {
            result = firstSet.getScoreBeforeDeuce(player1Score, player2Score);
        }
        System.out.println(result);
    }
}
