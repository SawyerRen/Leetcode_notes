package company.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i], s2 = words[i + 1];
            if (!valid(index, s1, s2)) return false;
        }
        return true;
    }

    private boolean valid(int[] index, String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            char c1 = s1.charAt(i), c2 = s2.charAt(j);
            if (c1 != c2) return index[c1 - 'a'] < index[c2 - 'a'];
            i++;
            j++;
        }
        return s1.length() <= s2.length();
    }
}
