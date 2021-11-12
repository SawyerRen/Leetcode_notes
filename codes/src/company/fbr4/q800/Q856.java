package company.fbr4.q800;

import java.util.Stack;

public class Q856 {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(cur);
                cur = 0;
            } else if (c == ')') {
                cur = stack.pop() + Math.max(1, cur * 2);
            }
        }
        return cur;
    }
}
