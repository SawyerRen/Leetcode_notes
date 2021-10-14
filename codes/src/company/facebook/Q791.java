package company.facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q791 {
    public String customSortString1(String order, String s) {
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

    public String customSortString(String order, String s) {
        int[] charOrder = new int[26];
        for (int i = 0; i < order.length(); i++) {
            charOrder[order.charAt(i) - 'a'] = i + 1;
        }
        List<Character> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (charOrder[c - 'a'] != 0) list.add(c);
            else builder.append(c);
        }
        list.sort(Comparator.comparingInt(a -> charOrder[a - 'a']));
        for (Character character : list) {
            builder.append(character);
        }
        return builder.toString();
    }
}
