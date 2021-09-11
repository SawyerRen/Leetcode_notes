package all_solution.q0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q30 {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0 || words.length == 0) return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        for (int i = 0; i < s.length() - totalLen + 1; i++) {
            if (isConcat(s.substring(i, i + totalLen), map, wordLen)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isConcat(String substring, Map<String, Integer> map, int wordLen) {
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < substring.length(); i += wordLen) {
            String word = substring.substring(i, i + wordLen);
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        return map.equals(count);
    }
}
