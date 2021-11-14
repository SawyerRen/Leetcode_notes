package company.fbr5.again;

import java.util.Stack;

public class Q151 {
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') left++;
        while (left <= right && s.charAt(right) == ' ') right--;
        StringBuilder builder = new StringBuilder();
        Stack<String> stack = new Stack<>();
        while (left <= right) {
            if (builder.length() > 0 && s.charAt(left) == ' ') {
                stack.push(builder.toString());
                builder.setLength(0);
            } else if (s.charAt(left) != ' ') {
                builder.append(s.charAt(left));
            }
            left++;
        }
        while (!stack.isEmpty()) {
            builder.append(" ").append(stack.pop());
        }
        return builder.toString();
    }
}
