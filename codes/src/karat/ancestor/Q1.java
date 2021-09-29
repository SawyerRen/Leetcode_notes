package karat.ancestor;

import java.util.*;

public class Q1 {
    public static List<Integer> zeroOrOneAncestor(int[][] edges) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[1]).add(edge[0]);
        }
        for (Integer edge : graph.keySet()) {
            if (graph.get(edge).size() < 2) res.add(edge);
        }
        return res;
    }
}
