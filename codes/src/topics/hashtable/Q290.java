package topics.hashtable;

import java.util.HashMap;
import java.util.Map;

public class Q290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        String[] split = s.split(" ");
        if (split.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!map1.containsKey(c)) {
                map1.put(c, split[i]);
            } else if (!map1.get(c).equals(split[i])) {
                return false;
            }
            if (!map2.containsKey(split[i])) {
                map2.put(split[i], c);
            } else if (map2.get(split[i]) != c) {
                return false;
            }
        }
        return true;
    }
}
