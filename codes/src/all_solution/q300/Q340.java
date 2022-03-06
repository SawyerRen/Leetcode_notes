package all_solution.q300;

import java.util.HashMap;
import java.util.Map;

public class Q340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int i = 0, j = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {
            char rc = s.charAt(j);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            while (map.size() > k) {
                char lc = s.charAt(i);
                map.put(lc, map.get(lc) - 1);
                if (map.get(lc) == 0) map.remove(lc);
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
