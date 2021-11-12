package company.fb2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Q1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        StringBuilder builder = new StringBuilder();
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int root = uf.find(i);
            map.putIfAbsent(root, new PriorityQueue<>());
            map.get(root).add(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            builder.append(map.get(uf.find(i)).poll());
        }
        return builder.toString();
    }

    class UnionFind {
        int[] parents;
        int[] size;

        public UnionFind(int n) {
            parents = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        int find(int i) {
            while (i != parents[i]) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }

        void union(int i, int j) {
            int p1 = find(i), p2 = find(j);
            if (p1 == p2) return;
            if (size[p1] > size[p2]) {
                parents[p2] = p1;
                size[p1] += size[p2];
            } else {
                parents[p1] = p2;
                size[p2] += size[p1];
            }
        }
    }
}
