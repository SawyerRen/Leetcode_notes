package all_solution.q0;

import java.util.HashMap;
import java.util.Map;

public class Q76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int minLen = s.length();
        int count = t.length();
        int i = 0, j = 0;
        boolean found = false;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) count--;
                map.put(c, map.get(c) - 1);
            }
            while (i <= j && count == 0) {
                found = true;
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    left = i;
                    right = j;
                }
                char leftChar = s.charAt(i);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) count++;
                }
                i++;
            }
            j++;
        }
        if (found) return s.substring(left, right + 1);
        return "";
    }
}
