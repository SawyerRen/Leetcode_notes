package company.fb2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q824 {
    public String toGoatLatin(String sentence) {
        String[] split = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int count = 1;
        for (String s : split) {
            if (set.contains(s.charAt(0))) {
                builder.append(s).append("ma");
            } else {
                builder.append(s.substring(1)).append(s.charAt(0)).append("ma");
            }
            for (int i = 0; i < count; i++) {
                builder.append("a");
            }
            count++;
            builder.append(" ");
        }
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }
}
