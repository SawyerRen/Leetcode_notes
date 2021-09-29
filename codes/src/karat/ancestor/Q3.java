package karat.ancestor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3 {
    int res = Integer.MIN_VALUE;

    public int findFarAncestor(int[][] edges, int x) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(graph, x, 0);
        return res;
    }

    private void dfs(Map<Integer, Set<Integer>> graph, int x, int dist) {
        if (graph.get(x).size() == 0) {
            res = Math.max(res, dist);
            return;
        }
        for (Integer parent : graph.get(x)) {
            dfs(graph, parent, dist + 1);
        }
    }
}
