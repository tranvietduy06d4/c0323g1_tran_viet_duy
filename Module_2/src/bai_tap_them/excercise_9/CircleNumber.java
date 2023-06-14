package bai_tap_them.excercise_9;

public class CircleNumber {
    public static void main(String[] args) {
        int startNumber = 5;
        int endNumber = 25;
        int checkNumber = startNumber;
        int count = 0;
        while (checkNumber <= endNumber) {
            if (checkCircleNumber(checkNumber)) {
                count++;
            }
            checkNumber++;
        }
        System.out.println(count);
    }

    public static boolean checkCircleNumber(int number) {
        String numberString = String.valueOf(number);
        if (numberString.charAt(0) == numberString.charAt(numberString.length() - 1)) {
            return true;
        }
        return false;
    }
}
