package all_solution.q1700;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            map.putIfAbsent(adjacentPair[0], new HashSet<>());
            map.putIfAbsent(adjacentPair[1], new HashSet<>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }
        int start = -1;
        for (Integer key : map.keySet()) {
            if (map.get(key).size() == 1) {
                start = key;
                break;
            }
        }
        int[] res = new int[adjacentPairs.length + 1];
        Set<Integer> visited = new HashSet<>();
        dfs(res, 0, start, map, visited);
        return res;
    }

    private void dfs(int[] res, int i, int start, Map<Integer, Set<Integer>> map, Set<Integer> visited) {
        if (i == res.length) return;
        res[i] = start;
        visited.add(start);
        for (Integer next : map.get(start)) {
            if (visited.contains(next)) continue;
            dfs(res, i + 1, next, map, visited);
        }
    }
}
