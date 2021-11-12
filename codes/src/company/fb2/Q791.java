package company.fb2;

import java.util.HashMap;
import java.util.Map;

public class Q791 {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (count[c - 'a'] > 0) {
                builder.append(c);
                count[c - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                builder.append((char) (i + 'a'));
                count[i]--;
            }
        }
        return builder.toString();
    }
}
