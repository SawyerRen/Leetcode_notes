package topics.strings;

import java.util.HashMap;
import java.util.Map;

public class Q294 {
    Map<String, Boolean> map = new HashMap<>();

    public boolean canWin(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String ss = s.substring(0, i) + "--" + s.substring(i + 1);
                if (!canWin(ss)) {
                    map.put(ss, false);
                    return true;
                } else {
                    map.put(ss, true);
                }
            }
        }
        return false;
    }
}
