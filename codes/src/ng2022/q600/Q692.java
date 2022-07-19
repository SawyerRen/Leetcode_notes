package ng2022.q600;

import java.util.*;

public class Q692 {
    class Node {
        String s;
        int count;

        public Node(String s, int count) {
            this.s = s;
            this.count = count;
        }
    }

    public List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.count == b.count ? a.s.compareTo(b.s) : b.count - a.count);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll().s);
        }
        return res;
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List[] lists = new List[words.length + 1];
        for (String word : map.keySet()) {
            Integer count = map.get(word);
            if (lists[count] == null) lists[count] = new ArrayList<String>();
            lists[count].add(word);
        }
        List<String> res = new ArrayList<>();
        for (int i = lists.length - 1; i >= 0; i--) {
            if (k == 0) break;
            if (lists[i] != null) {
                List<String> list = lists[i];
                list.sort(String::compareTo);
                for (String s : list) {
                    if (k == 0) break;
                    res.add(s);
                    k--;
                }
            }
        }
        return res;
    }
}
