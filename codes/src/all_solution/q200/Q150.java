package all_solution.q200;

import java.util.Stack;

public class Q150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
                Integer n2 = stack.pop();
                Integer n1 = stack.pop();
                switch (token) {
                    case "+" -> stack.push(n1 + n2);
                    case "-" -> stack.push(n1 - n2);
                    case "/" -> stack.push(n1 / n2);
                    case "*" -> stack.push(n1 * n2);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
