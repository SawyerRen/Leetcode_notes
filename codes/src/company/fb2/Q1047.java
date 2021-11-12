package company.fb2;

import java.util.Arrays;

public class Q1047 {
    public String removeDuplicates(String s) {
        char[] chars = new char[s.length()];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            chars[index] = s.charAt(i);
            if (index > 0 && chars[index] == chars[index - 1]) {
                index--;
            } else {
                index++;
            }
        }
        return String.valueOf(Arrays.copyOf(chars, index));
    }

    public String removeDuplicates1(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (builder.length() > 0 && builder.charAt(builder.length() - 1) == c) {
                builder.setLength(builder.length() - 1);
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
