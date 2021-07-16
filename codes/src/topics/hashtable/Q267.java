package topics.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q267 {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 找到单数的字符，如果出现两次，不是回文，直接返回res
        Character singleChar = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                if (singleChar == null) {
                    singleChar = entry.getKey();
                    map.put(entry.getKey(), map.get(entry.getKey()) - 1);
                } else return res;
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(singleChar);
        helper(res, map, builder, s.length());
        return res;
    }

    private void helper(List<String> res, Map<Character, Integer> map, StringBuilder builder, int length) {
        int len = builder.length();
        if (len == length) {
            res.add(builder.toString());
            return;
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                char key = entry.getKey();
                builder.insert(0, key).append(key);
                map.put(key, map.get(key) - 2);
                helper(res, map, builder, length);
                builder.deleteCharAt(0).deleteCharAt(builder.length() - 1);
                map.put(key, map.get(key) + 1);
            }
        }
    }
}
