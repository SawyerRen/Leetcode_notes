package topics.hashtable;

import java.util.HashMap;
import java.util.Map;

public class Q266 {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean findOne = false;
        for (Integer count : map.values()) {
            if (count % 2 == 0) continue;
            if (findOne) return false;
            findOne = true;
        }
        return true;
    }
}
