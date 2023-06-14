package bai_tap_them.excercise_3;

public class BeautifulArray {
    public static void main(String[] args) {
        int[] integerArray = {1, 2, 3};
        boolean result = checkBeautifulArray(integerArray);
        System.out.println(result);

    }

    public static boolean checkBeautifulArray(int[] array) {
        int sumFirst = 0;
        int sumLast = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (j < i) {
                    sumFirst += array[j];
                }
                if (j > i) {
                    sumLast += array[j];
                }
            }
            if (sumFirst == sumLast) {
                return true;
            }
            sumFirst = 0;
            sumLast = 0;
        }
        return false;
    }
}
