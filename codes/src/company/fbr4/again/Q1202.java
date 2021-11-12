package company.fbr4.again;

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
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int parentIndex = uf.find(i);
            map.putIfAbsent(parentIndex, new PriorityQueue<>());
            map.get(parentIndex).add(s.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            PriorityQueue<Character> pq = map.get(uf.find(i));
            builder.append(pq.poll());
        }
        return builder.toString();
    }

    class UnionFind {
        int size;
        int[] parents;

        public UnionFind(int size) {
            this.size = size;
            parents = new int[size];
            for (int i = 0; i < size; i++) {
                parents[i] = i;
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
            parents[p2] = p1;
            size--;
        }
    }
}
