package company.fbr4.again;

import java.util.Stack;

public class Q151 {
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right && s.charAt(left) == ' ') left++;
        while (left < right && s.charAt(right) == ' ') right--;
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c == ' ' && builder.length() > 0) {
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
