package frequency.q100;

import java.util.LinkedList;
import java.util.Stack;

public class Q150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int val1 = stack.pop();
                    int val2 = stack.pop();
                    stack.push(val2 - val1);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int val1 = stack.pop();
                    int val2 = stack.pop();
                    stack.push(val2 / val1);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
