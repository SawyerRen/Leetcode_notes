package topics.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q387 {
    public int firstUniqChar(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) res = Math.min(res, entry.getValue().get(0));
        }
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }
}
