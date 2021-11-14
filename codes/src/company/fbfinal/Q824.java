package company.fbfinal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q824 {
    public String toGoatLatin(String sentence) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (String s : sentence.split(" ")) {
            if (vowels.contains(s.charAt(0))) {
                builder.append(s).append("ma");
            } else {
                builder.append(s.substring(1)).append(s.charAt(0)).append("ma");
            }
            count++;
            for (int i = 0; i < count; i++) {
                builder.append('a');
            }
            builder.append(" ");
        }
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }
}
