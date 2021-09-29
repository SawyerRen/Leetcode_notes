package karat.ancestor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q2 {
    public static boolean hasCommonAncestor(int[][] edges, int x, int y) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> parentX = new HashSet<>();
        Set<Integer> parentY = new HashSet<>();
        findParents(parentX, graph, x);
        findParents(parentY, graph, y);
        for (Integer px : parentX) {
            if (parentY.contains(px)) return true;
        }
        return false;
    }

    private static void findParents(Set<Integer> parents, Map<Integer, Set<Integer>> graph, int x) {
        if (graph.get(x).size() == 0) return;
        for (Integer parent : graph.get(x)) {
            if (parents.contains(parent)) continue;
            parents.add(parent);
            findParents(parents, graph, parent);
        }
    }
}
