package frequency.q0;

import java.util.Stack;

public class Q20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                switch (c) {
                    case ')':
                        if (stack.pop() != '(') return false;
                        break;
                    case ']':
                        if (stack.pop() != '[') return false;
                        break;
                    case '}':
                        if (stack.pop() != '{') return false;
                        break;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
