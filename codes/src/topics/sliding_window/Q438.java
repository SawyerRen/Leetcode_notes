package topics.sliding_window;

import java.util.ArrayList;
import java.util.List;

public class Q438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] hash = new int[26];
        for (char c : p.toCharArray()) {
            hash[c - 'a']++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (right - left >= p.length()) {
                if (hash[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                hash[s.charAt(left) - 'a']++;
                left++;
            }
            if (hash[s.charAt(right) - 'a'] > 0) count--;
            if (count == 0) res.add(left);
            hash[s.charAt(right) - 'a']--;
            right++;
        }
        return res;
    }
}
