package company.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int i = 0, j = 0;
        int res = 0;
        int distinct = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {
            char rc = s.charAt(j);
            if (!map.containsKey(rc)) distinct++;
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            while (distinct > k) {
                char lc = s.charAt(i);
                map.put(lc, map.get(lc) - 1);
                if (map.get(lc) == 0) {
                    distinct--;
                    map.remove(lc);
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
