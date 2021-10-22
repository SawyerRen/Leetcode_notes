package company.facebook;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q1249 {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) continue;
                open--;
            }
            builder.append(c);
        }
        open = 0;
        StringBuilder builder1 = new StringBuilder();
        for (char c : builder.reverse().toString().toCharArray()) {
            if (c == ')') {
                open++;
            } else if (c == '(') {
                if (open == 0) continue;
                open--;
            }
            builder1.append(c);
        }
        return builder1.reverse().toString();
    }

    public String minRemoveToMakeValid1(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> validIndex = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    validIndex.add(i);
                    validIndex.add(stack.pop());
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '(' && c != ')') builder.append(c);
            else {
                if (validIndex.contains(i)) builder.append(c);
            }
        }
        return builder.toString();
    }
}
