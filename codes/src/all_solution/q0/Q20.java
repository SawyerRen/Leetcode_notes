package all_solution.q0;

import java.util.Stack;

public class Q20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                switch (c) {
                    case ')':
                        if (stack.peek() == '(') stack.pop();
                        else return false;
                        break;
                    case ']':
                        if (stack.peek() == '[') stack.pop();
                        else return false;
                        break;
                    case '}':
                        if (stack.peek() == '{') stack.pop();
                        else return false;
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}
