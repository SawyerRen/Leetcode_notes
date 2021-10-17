package company.facebook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q824 {
    public String toGoatLatin(String sentence) {
        String[] split = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            StringBuilder word = new StringBuilder();
            if (vowels.contains(s.charAt(0))) {
                word.append(s).append("ma");
            } else {
                word.append(s, 1, s.length()).append(s.charAt(0)).append("ma");
            }
            word.append("a".repeat(i + 1));
            if (builder.length() == 0) builder.append(word);
            else builder.append(" ").append(word);
        }
        return builder.toString();
    }
}
