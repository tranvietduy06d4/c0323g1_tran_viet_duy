package ss11_dsa_stack_and_queue.bai_tap.bai_1_dao_nguoc_phan_tu_trong_stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Integer[] integerArray = {1, 2, 3, 4, 5};
        for (Integer i : integerArray) {
            stack.push(i);
        }
        System.out.println(stack);

        for (int i = 0; i < integerArray.length; i++) {
            integerArray[i] = stack.pop();
        }
        System.out.println(Arrays.toString(integerArray));

        Stack<String> wordStack = new Stack<>();
        String wordString = "Tran Viet  Duy ";
        String[] newString = wordString.split(" ");
        for (String i : newString) {
            if (!i.equals("")) {
                wordStack.push(i);
            }
        }
        System.out.println(wordStack);

        int newSize = wordStack.size();

        wordString = "";
        for (int i = 0; i < newSize; i++) {
            wordString += wordStack.pop() + " ";
        }
        System.out.println(wordString);

    }
}
