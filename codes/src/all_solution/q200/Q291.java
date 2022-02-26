package all_solution.q200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q291 {
    Map<Character, String> map = new HashMap<>();
    Set<String> set = new HashSet<>();

    public boolean wordPatternMatch(String pattern, String s) {
        return helper(pattern, 0, s, 0);
    }

    private boolean helper(String pattern, int i, String s, int j) {
        if (i == pattern.length() && j == s.length()) return true;
        if (i == pattern.length() || j == s.length()) return false;
        char c = pattern.charAt(i);
        if (map.containsKey(c)) {
            String sub = map.get(c);
            if (s.startsWith(sub, j)) {
                return helper(pattern, i + 1, s, j + sub.length());
            }
            return false;
        }
        for (int k = j; k < s.length(); k++) {
            String sub = s.substring(j, k + 1);
            if (set.contains(sub)) continue;
            set.add(sub);
            map.put(c, sub);
            if (helper(pattern, i + 1, s, j + sub.length())) return true;
            set.remove(sub);
            map.remove(c);
        }
        return false;
    }
}
