package company.fbr3;

import java.util.HashSet;
import java.util.Set;

public class Q1249 {
    public String minRemoveToMakeValid(String s) {
        int close = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') close++;
        }
        StringBuilder builder = new StringBuilder();
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
                if (close > 0) {
                    builder.append(c);
                    close--;
                }
            } else if (c == ')') {
                if (open > 0) {
                    builder.append(c);
                    open--;
                } else {
                    close--;
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public String minRemoveToMakeValid1(String s) {
        int open = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') open++;
            else if (s.charAt(i) == ')') {
                if (open > 0) open--;
                else set.add(i);
            }
        }
        open = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') open++;
            else if (s.charAt(i) == '(') {
                if (open > 0) open--;
                else set.add(i);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(i)) continue;
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
