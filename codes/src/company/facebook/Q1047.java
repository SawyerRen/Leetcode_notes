package company.facebook;

import java.util.Stack;

public class Q1047 {
    public String removeDuplicates(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (builder.length() > 0 && c == builder.charAt(builder.length() - 1)) {
                builder.setLength(builder.length() - 1);
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
