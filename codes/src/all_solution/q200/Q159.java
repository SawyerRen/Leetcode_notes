package all_solution.q200;

import java.util.HashMap;
import java.util.Map;

public class Q159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // char c出现的最后一个index
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int res = 0;
        while (j < s.length()) {
            char cj = s.charAt(j);
            map.put(cj, j);
            while (map.size() > 2) {
                int left = s.length() - 1;
                for (Integer index : map.values()) {
                    left = Math.min(left, index);
                }
                map.remove(s.charAt(left));
                i = left + 1;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }

    public int lengthOfLongestSubstringTwoDistinct1(String s) {
        int i = 0, j = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        while (j < s.length()) {
            char cj = s.charAt(j);
            if (!map.containsKey(cj)) {
                count++;
                map.put(cj, 1);
            } else {
                map.put(cj, map.get(cj) + 1);
            }
            while (count > 2) {
                char ci = s.charAt(i);
                if (map.get(ci) == 1) {
                    map.remove(ci);
                    count--;
                } else {
                    map.put(ci, map.get(ci) - 1);
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
