package topics.stack;

import java.util.Stack;

public class Q402 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        Stack<Integer> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (char c : num.toCharArray()) {
            int n = c - '0';
            while (!stack.isEmpty() && n < stack.peek() && count < k) {
                stack.pop();
                count++;
            }
            stack.push(n);
        }
        while (count < k) {
            stack.pop();
            count++;
        }
        if (stack.isEmpty()) return "0";
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        while (builder.length() > 1 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }
}
