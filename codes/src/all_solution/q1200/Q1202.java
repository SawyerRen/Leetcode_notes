package all_solution.q1200;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Q1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (List<Integer> pair : pairs) {
            union(parents, pair.get(0), pair.get(1));
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parentIndex = find(parents, i);
            map.putIfAbsent(parentIndex, new PriorityQueue<>());
            map.get(parentIndex).add(s.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(map.get(find(parents, i)).poll());
        }
        return builder.toString();
    }

    private void union(int[] parents, Integer i, Integer j) {
        int p1 = find(parents, i);
        int p2 = find(parents, j);
        if (p1 == p2) return;
        parents[p2] = p1;
    }

    private int find(int[] parents, Integer i) {
        while (i != parents[i]) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }
}
