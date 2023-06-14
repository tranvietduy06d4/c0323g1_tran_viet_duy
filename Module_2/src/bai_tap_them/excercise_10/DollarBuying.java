package bai_tap_them.excercise_10;

public class DollarBuying {
    public static void main(String[] args) {
        int[] dollarPrice = {3, 5, 2, 7, 1};
        int number = 7;
        int result = checkMaxDollar(dollarPrice) + number;
        System.out.println(result);

    }

    public static int checkMaxDollar(int[] dollarPrice) {
        int maxDollarAmount = 0;
        for (int i = 0; i < dollarPrice.length - 1; i++) {
            if (dollarPrice[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < dollarPrice.length; j++) {
                if (dollarPrice[j] - dollarPrice[i] > maxDollarAmount) {
                    maxDollarAmount = dollarPrice[j] - dollarPrice[i];
                }
            }
        }
        return maxDollarAmount;
    }
}
