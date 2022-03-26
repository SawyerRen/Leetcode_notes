package all_solution.q1000;

import java.util.*;

public class Q1048 {
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));
        int res = 0;
        for (String word : words) {
            res = Math.max(res, helper(word, set, map));
        }
        return res;
    }

    private int helper(String word, Set<String> set, Map<String, Integer> map) {
        if (map.containsKey(word)) return map.get(word);
        int res = 1;
        for (int i = 0; i < word.length(); i++) {
            String pre = word.substring(0, i) + word.substring(i + 1);
            if (set.contains(pre)) {
                res = Math.max(res, helper(pre, set, map) + 1);
            }
        }
        map.put(word, res);
        return res;
    }
}
