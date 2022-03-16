package all_solution.q600;

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
        for (int i = lists.length - 1; i > 0; i--) {
            if (k == 0) break;
            if (lists[i] != null) {
                List<String> list = lists[i];
                Collections.sort(list);
                for (int j = 0; j < list.size() && k > 0; j++) {
                    res.add(list.get(j));
                    k--;
                }
            }
        }
        return res;
    }
}
