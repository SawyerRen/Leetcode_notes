package company.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q76 {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = t.length();
        int i = 0, j = 0;
        int minLen = s.length(), left = 0, right = 0;
        boolean found = false;
        while (j < s.length()) {
            char rc = s.charAt(j);
            if (map.containsKey(rc)) {
                map.put(rc, map.get(rc) - 1);
                if (map.get(rc) >= 0) count--;
            }
            while (i <= j && count == 0) {
                found = true;
                int curLen = j - i + 1;
                if (curLen <= minLen) {
                    minLen = curLen;
                    left = i;
                    right = j;
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
        if (!found) return "";
        return s.substring(left, right + 1);
    }
}
