package topics.stack;

import java.util.Stack;

public class Q20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || c == '(' || c == '{' || c == '[') stack.push(c);
            else if (match(stack.peek(), c)) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private boolean match(Character c1, char c2) {
        return c1 == '(' && c2 == ')' || c1 == '[' && c2 == ']' || c1 == '{' && c2 == '}';
    }
}
