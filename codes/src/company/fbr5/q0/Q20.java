package company.fbr5.q0;

import java.util.Stack;

public class Q20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                if (stack.peek() == '(' && c != ')') return false;
                if (stack.peek() == '[' && c != ']') return false;
                if (stack.peek() == '{' && c != '}') return false;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
