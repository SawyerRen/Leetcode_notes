package topics.two_pointer;

import java.util.HashMap;
import java.util.Map;

public class Q76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean found = false;
        int left = 0, right = s.length() - 1;
        int minLen = s.length(), count = t.length();
        int i = 0, j = 0;
        while (j < s.length()) {
            Character c = s.charAt(j);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) count--;
                map.put(c, map.get(c) - 1);
            }
            while (i <= j && count == 0) {
                found = true;
                int curLen = j - i + 1;
                if (curLen < minLen) {
                    minLen = curLen;
                    left = i;
                    right = j;
                }
                Character lc = s.charAt(i);
                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);
                    if (map.get(lc) > 0) count++;
                }
                i++;
            }
            j++;
        }
        return found ? s.substring(left, right + 1) : "";
    }
}
