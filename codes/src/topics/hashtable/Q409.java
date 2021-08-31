package topics.hashtable;

import java.util.HashMap;
import java.util.Map;

public class Q409 {
    public int longestPalindrome(String s) {
        int[] hash = new int[128];
        for (char c : s.toCharArray()) {
            hash[c]++;
        }
        int res = 0;
        for (int val : hash) {
            res += val / 2 * 2;
        }
        if (res < s.length()) return res + 1;
        return res;
    }
}
