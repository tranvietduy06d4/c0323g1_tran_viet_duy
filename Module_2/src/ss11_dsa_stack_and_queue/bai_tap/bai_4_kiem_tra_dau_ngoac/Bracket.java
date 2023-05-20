package ss11_dsa_stack_and_queue.bai_tap.bai_4_kiem_tra_dau_ngoac;

import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        String string = "((a + b) - (c +d))";
        boolean result = checkBracket(string);
        System.out.println(result);
    }

    public static boolean checkBracket(String string) {
        String[] newString = string.split("");
        Stack<String> stack = new Stack<>();

        for (String i : newString) {
            if (i.equals("(")) {
                stack.push(i);
            }

            if (i.equals(")")) {
                if (stack.size() == 0) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.size() != 0) {
            return false;
        }
        return true;

    }
}
