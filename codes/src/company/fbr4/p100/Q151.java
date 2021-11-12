package company.fbr4.p100;

import java.util.Stack;

public class Q151 {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') left++;
        while (left <= right && s.charAt(right) == ' ') right--;
        Stack<String> stack = new Stack<>();
        while (left <= right) {
            char c = s.charAt(left);
            if (builder.length() > 0 && c == ' ') {
                stack.push(builder.toString());
                builder.setLength(0);
            } else if (c != ' ') {
                builder.append(c);
            }
            left++;
        }
        stack.push(builder.toString());
        builder.setLength(0);
        while (!stack.isEmpty()) {
            builder.append(stack.pop()).append(" ");
        }
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }
}
