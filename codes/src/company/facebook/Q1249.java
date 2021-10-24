package company.facebook;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q1249 {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        int n = s.length();
        boolean[] remove = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') open++;
            else if (s.charAt(i) == ')') {
                if (open > 0) open--;
                else remove[i] = true;
            }
        }
        int close = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') close++;
            else if (s.charAt(i) == '(') {
                if (close > 0) close--;
                else remove[i] = true;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (remove[i]) continue;
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public String minRemoveToMakeValid1(String s) {
        Set<Integer> validIndex = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == ')') {
                validIndex.add(stack.pop());
                validIndex.add(i);
            } else if (s.charAt(i) == '(') {
                stack.push(i);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '(' && c != ')') {
                builder.append(c);
            } else if (validIndex.contains(i)) {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
