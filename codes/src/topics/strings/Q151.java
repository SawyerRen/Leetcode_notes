package topics.strings;

import java.util.Arrays;

public class Q151 {
    public String reverseWords(String s) {
        String[] split = s.trim().split(" +");
        StringBuilder builder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            builder.append(split[i]).append(" ");
        }
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }
}
