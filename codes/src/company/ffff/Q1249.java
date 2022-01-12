package company.ffff;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q1249 {
    public String minRemoveToMakeValid(String s) {
        int right = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') right++;
        }
        int left = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (right > 0) {
                    right--;
                    builder.append(c);
                }
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    builder.append(c);
                    left--;
                } else {
                    right--;
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public String minRemoveToMakeValid1(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> validIndex = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (!stack.isEmpty()) {
                    validIndex.add(i);
                    validIndex.add(stack.pop());
                }
            }
            if (c == '(') {
                stack.push(i);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '(' && c != ')') {
                builder.append(c);
            } else {
                if (validIndex.contains(i)) {
                    builder.append(c);
                }
            }
        }
        return builder.toString();
    }
}
