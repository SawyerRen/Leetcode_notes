package all_solution.q0;

import java.util.Stack;

public class Q32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.size() > 1 && c == ')' && s.charAt(stack.peek()) == '(') {
                stack.pop();
                res = Math.max(res, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return res;
    }
}
