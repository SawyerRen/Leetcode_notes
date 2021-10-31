package company.fbr3;

import java.util.Stack;

public class Q20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && isPair(stack.peek(), c)) stack.pop();
            else stack.push(c);
        }
        return stack.isEmpty();
    }

    private boolean isPair(Character peek, char c) {
        return (peek == '(' && c == ')') || (peek == '[' && c == ']') || (peek == '{' && c == '}');
    }
}
