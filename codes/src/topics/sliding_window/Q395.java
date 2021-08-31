package topics.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Q395 {
    public int longestSubstring(String s, int k) {
        if (s.length() == 0) return 0;
        if (k < 2) return s.length();
        return helper(s, k, 0, s.length());
    }

    private int helper(String s, int k, int left, int right) {
        if (left >= right) return 0;
        int[] hash = new int[26];
        boolean valid = true;
        for (int i = left; i < right; i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] > 0 && hash[i] < k) {
                valid = false;
                break;
            }
        }
        if (valid) return right - left;
        int res = 0, start = left;
        for (int i = left; i < right; i++) {
            if (hash[s.charAt(i) - 'a'] < k) {
                res = Math.max(res, helper(s, k, start, i));
                start = i + 1;
            }
        }
        res = Math.max(res, helper(s, k, start, right));
        return res;
    }
}
