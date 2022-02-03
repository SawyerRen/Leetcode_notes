package all_solution.q100;

import java.util.Stack;

public class Q150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                switch (token) {
                    case "+" -> stack.push(n1 + n2);
                    case "-" -> stack.push(n2 - n1);
                    case "*" -> stack.push(n1 * n2);
                    case "/" -> stack.push(n2 / n1);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
