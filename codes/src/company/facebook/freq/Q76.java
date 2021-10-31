package company.facebook.freq;

import java.util.HashMap;
import java.util.Map;

public class Q76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0, j = 0, minLen = s.length() + 1, left = 0, right = 0, count = t.length();
        while (j < s.length()) {
            char rc = s.charAt(j);
            if (map.containsKey(rc)) {
                map.put(rc, map.get(rc) - 1);
                if (map.get(rc) >= 0) count--;
            }
            while (count == 0) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    left = i;
                    right = j + 1;
                }
                char lc = s.charAt(i);
                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);
                    if (map.get(lc) >= 1) count++;
                }
                i++;
            }
            j++;
        }
        if (minLen == s.length() + 1) return "";
        return s.substring(left, right);
    }
}
