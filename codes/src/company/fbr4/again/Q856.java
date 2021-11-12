package company.fbr4.again;

import java.util.Stack;

public class Q856 {
    public int scoreOfParentheses(String s) {
        int cur = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(cur);
                cur = 0;
            } else {
                cur = stack.pop() + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }
}
