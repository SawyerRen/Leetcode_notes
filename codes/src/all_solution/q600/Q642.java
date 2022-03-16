package all_solution.q600;

import java.util.*;

public class Q642 {
}

class AutocompleteSystem {
    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> countMap;

        public TrieNode() {
            children = new HashMap<>();
            countMap = new HashMap<>();
        }
    }

    TrieNode root;
    String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    private void add(String sentence, int time) {
        TrieNode cur = root;
        for (char c : sentence.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
            cur.countMap.put(sentence, cur.countMap.getOrDefault(sentence, 0) + time);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return res;
        }
        prefix += c;
        TrieNode cur = root;
        for (char c1 : prefix.toCharArray()) {
            if (!cur.children.containsKey(c1)) return res;
            cur = cur.children.get(c1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.getValue().equals(b.getValue())) return a.getKey().compareTo(b.getKey());
            return b.getValue() - a.getValue();
        });
        pq.addAll(cur.countMap.entrySet());
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            res.add(pq.poll().getKey());
        }
        return res;
    }
}
