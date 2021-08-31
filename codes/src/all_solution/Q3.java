package all_solution;

import java.util.HashSet;
import java.util.Set;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int res = 0;
        char[] chars = s.toCharArray();
        while (j < chars.length) {
            while (set.contains(chars[j])) {
                set.remove(chars[i]);
                i++;
            }
            set.add(chars[j]);
            res = Math.max(res, set.size());
            j++;
        }
        return res;
    }
}
