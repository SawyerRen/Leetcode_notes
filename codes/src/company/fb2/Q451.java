package company.fb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] lists = new List[s.length() + 1];
        for (Character c : map.keySet()) {
            Integer count = map.get(c);
            if (lists[count] == null) lists[count] = new ArrayList<>();
            lists[count].add(c);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = lists.length - 1; i > 0; i--) {
            if (lists[i] != null) {
                for (Character c : lists[i]) {
                    for (int j = 0; j < i; j++) {
                        builder.append(c);
                    }
                }
            }
        }
        return builder.toString();
    }
}
