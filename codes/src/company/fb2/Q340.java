package company.fb2;

import java.util.HashMap;
import java.util.Map;

public class Q340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, res = 0;
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while (map.size() > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                i++;
            }
            res = Math.max(j - i + 1, res);
            j++;
        }
        return res;
    }
}
