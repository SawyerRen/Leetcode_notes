package company.facebook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q824 {
    public String toGoatLatin(String sentence) {
        String[] split = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U'));
        for (int i = 0; i < split.length; i++) {
            char c = split[i].charAt(0);
            if (set.contains(c)) {
                builder.append(split[i]).append("ma");
            } else {
                builder.append(split[i].substring(1)).append(c).append("ma");
            }
            builder.append("a".repeat(i + 1));
            builder.append(" ");
        }
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }
}
