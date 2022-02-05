package all_solution.q100;

import java.util.HashMap;
import java.util.Map;

public class Q159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, res = 0;
        while (j < s.length()) {
            char rc = s.charAt(j);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            while (map.size() > 2) {
                char lc = s.charAt(i);
                map.put(lc, map.get(lc) - 1);
                if (map.get(lc) == 0) map.remove(lc);
                i++;
            }
            j++;
            res = Math.max(res, j - i);
        }
        return res;
    }
}
