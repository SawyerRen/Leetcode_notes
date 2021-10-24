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
            if (!helper(index, words[i], words[i + 1])) return false;
        }
        return true;
    }

    private boolean helper(int[] index, String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if (c1 == c2) {
                i++;
                j++;
            } else {
                return index[s1.charAt(i) - 'a'] < index[s2.charAt(i) - 'a'];
            }
        }
        return s1.length() <= s2.length();
    }
}
