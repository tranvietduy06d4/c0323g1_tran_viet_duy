package ss11_dsa_stack_and_queue.bai_tap.bai_3_thap_phan_sang_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your integer value to check: ");
        int number = Integer.parseInt(scanner.nextLine());
        String result = convertDecimalToBinary(number);
        System.out.println(result);
    }

    public static String convertDecimalToBinary(int number) {
        Stack<Integer> binaryStack = new Stack<>();
        String binaryString = "";
        while (number != 0) {
            binaryStack.push(number % 2);
            number = number / 2;
        }

        System.out.println(binaryStack);

        int newSize = binaryStack.size();
        for (int i = 0; i < newSize; i++) {
            binaryString += binaryStack.pop();
        }
        return binaryString;
    }
}
