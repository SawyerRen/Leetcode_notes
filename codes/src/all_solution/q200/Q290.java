package all_solution.q200;

import java.util.HashMap;
import java.util.Map;

public class Q290 {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (split.length != pattern.length()) return false;
        Map<String, Character> map1 = new HashMap<>();
        Map<Character, String> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = split[i];
            if (map1.containsKey(str) && !map1.get(str).equals(c)) return false;
            if (map2.containsKey(c) && !map2.get(c).equals(str)) return false;
            map1.put(str, c);
            map2.put(c, str);
        }
        return true;
    }
}
