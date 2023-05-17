package ss8_clean_code.bai_tap.bai_tap_1_tennis;

public class TennisGame {

    static String score = "";
    static int tempScore = 0;

    //
    public static String getScoreDeuce(int playerScore) {
        switch (playerScore) {
            case 0:
                score = "Love-All";
                return score;
            case 1:
                score = "Fifteen-All";
                return score;
            case 2:
                score = "Thirty-All";
                return score;
            case 3:
                score = "Forty-All";
                return score;
            default:
                score = "Deuce";
                return score;
        }
    }

//

    public static String getScoreAfterDeuce(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }


    //
    public static String getScoreBeforeDeuce(int player1Score, int player2Score) {
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1Score;
            } else {
                score += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }
}
