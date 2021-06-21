package topics.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Q76 {
    public String minWindow(String s, String t) {
        // map保存t的每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 初始化最短距离为s的长度和两个指针
        int left = 0, right = s.length() - 1;
        int i = 0, j = 0;
        int count = t.length();
        int minLen = s.length();
        boolean canFind = false;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    count--;
                }
                map.put(c, map.get(c) - 1);
            }
            while (i <= j && count == 0) {
                canFind = true;
                int curLen = j - i + 1;
                if (curLen < minLen) {
                    left = i;
                    right = j;
                    minLen = curLen;
                }
                char lc = s.charAt(i);
                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);
                    if (map.get(lc) > 0) count++;
                }
                i++;
            }
            j++;
        }
        if (canFind) return s.substring(left, right + 1);
        return "";
    }
}
