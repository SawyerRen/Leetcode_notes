package topics.backtracking;

import java.util.HashMap;
import java.util.Map;

public class Q291 {
    Map<Character, String> map = new HashMap<>();

    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        char c = pattern.charAt(0);
        for (int i = 1; i <= str.length() - pattern.length(); i++) {
            String substring = str.substring(0, i);
            String patternString = map.get(c);
            if (patternString == null && !map.containsValue(substring) || patternString != null && patternString.equals(substring)) {
                map.put(c, substring);
                if (wordPatternMatch(pattern.substring(1), str.substring(i))) {
                    return true;
                } else if (patternString == null) {
                    map.remove(c);
                }
            }
        }
        return false;
    }
}
