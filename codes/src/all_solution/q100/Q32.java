package all_solution.q100;

import java.util.Stack;

public class Q32 {
    public int longestValidParentheses(String s) {
        int res = 0;
        // 保存遍历到的index
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.peek() != -1 && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    res = Math.max(res, i - stack.peek());
                } else {
                    stack.push(i);
                }
            } else {
                stack.push(i);
            }
        }
        return res;
    }
}
