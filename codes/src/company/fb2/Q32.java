package company.fb2;

import java.util.Stack;

public class Q32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (stack.size() > 1 && s.charAt(i) == ')' && s.charAt(stack.peek()) == '(') {
                stack.pop();
                res = Math.max(i - stack.peek(), res);
            } else {
                stack.push(i);
            }
        }
        return res;
    }
}
