package company.fbr4.q600;

import java.util.*;

public class Q692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String>[] lists = new List[words.length + 1];
        for (String s : map.keySet()) {
            int count = map.get(s);
            if (lists[count] == null) lists[count] = new ArrayList<>();
            lists[count].add(s);
        }
        List<String> res = new ArrayList<>();
        for (int i = lists.length - 1; i >= 0; i--) {
            if (lists[i] != null) {
                if (res.size() == k) break;
                Collections.sort(lists[i]);
                for (String s : lists[i]) {
                    if (res.size() < k) {
                        res.add(s);
                    }
                }
            }
        }
        return res;
    }
}
