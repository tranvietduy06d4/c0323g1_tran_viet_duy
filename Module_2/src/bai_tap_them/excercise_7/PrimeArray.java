package bai_tap_them.excercise_7;

import java.util.*;

public class PrimeArray {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your array length: ");
        int arraySize = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the length of your element in array: ");
        int elementSize = Integer.parseInt(scanner.nextLine());
        int[][] array = new int[arraySize][elementSize];
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < elementSize; j++) {
                System.out.println("Please enter value of element " + i + ", " + j);
                array[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }

        List<Integer> integerList = createPrimeList(array);
        System.out.println(integerList);

    }

    public static boolean checkPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> createPrimeList(int[][] integerArray) {
        List<Integer> integerList = new ArrayList<>();
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < integerArray.length; i++) {
            for (int j = 0; j < integerArray[i].length; j++) {
                if (checkPrime(integerArray[i][j])) {
                    integerSet.add(integerArray[i][j]);

                }
            }
        }

        for (Integer i : integerSet) {
            integerList.add(i);
        }
        return integerList;
    }
}
