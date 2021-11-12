package company.fb2;

import java.util.HashSet;
import java.util.Set;

public class Q1249 {
    public String minRemoveToMakeValid(String s) {
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') close++;
        }
        int open = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (close > 0) {
                    builder.append(c);
                    close--;
                }
                open++;
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
        Set<Integer> inValid = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                if (open > 0) open--;
                else inValid.add(i);
            }
        }
        open = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') open++;
            else if (s.charAt(i) == '(') {
                if (open > 0) open--;
                else inValid.add(i);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (inValid.contains(i)) continue;
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
