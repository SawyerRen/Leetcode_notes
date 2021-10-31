package company.facebook.freq;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q1249 {
    public String minRemoveToMakeValid(String s) {
        int close = 0, open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') close++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
                if (close > 0) {
                    close--;
                    builder.append(s.charAt(i));
                }
            } else if (s.charAt(i) == ')') {
                if (open > 0) {
                    builder.append(s.charAt(i));
                    open--;
                } else {
                    close--;
                }
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    public String minRemoveToMakeValid2(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> valid = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == ')') {
                valid.add(stack.pop());
                valid.add(i);
            } else if (s.charAt(i) == '(') {
                stack.push(i);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') builder.append(s.charAt(i));
            else {
                if (valid.contains(i)) builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    public String minRemoveToMakeValid1(String s) {
        Set<Integer> invalidIndex = new HashSet<>();
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') open++;
            else if (s.charAt(i) == ')') {
                if (open > 0) open--;
                else invalidIndex.add(i);
            }
        }
        open = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') open++;
            else if (s.charAt(i) == '(') {
                if (open > 0) open--;
                else invalidIndex.add(i);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (invalidIndex.contains(i)) continue;
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
