package ng2022.q0;

import java.util.Stack;

public class Q20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                switch (c) {
                    case ')' -> {
                        if (stack.peek() != '(') return false;
                    }
                    case ']' -> {
                        if (stack.peek() != '[') return false;
                    }
                    case '}' -> {
                        if (stack.peek() != '{') return false;
                    }
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
