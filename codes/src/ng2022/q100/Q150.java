package ng2022.q100;

import java.util.Stack;

public class Q150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int n1 = stack.pop();
                    int n2 = stack.pop();
                    stack.push(n2 - n1);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int n1 = stack.pop();
                    int n2 = stack.pop();
                    stack.push(n2 / n1);
                }
                default -> {
                    stack.push(Integer.parseInt(token));
                }
            }
        }
        return stack.pop();
    }
}
