package company.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q953 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!valid(words[i], words[i + 1], map)) return false;
        }
        return true;
    }

    private boolean valid(String s1, String s2, Map<Character, Integer> map) {
        int minLen = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            return map.get(s1.charAt(i)) < map.get(s2.charAt(i));
        }
        return s1.length() <= s2.length();
    }
}
