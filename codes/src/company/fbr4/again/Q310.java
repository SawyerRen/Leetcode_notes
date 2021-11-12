package company.fbr4.again;

import java.util.*;

public class Q310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] preCount = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            preCount[edge[0]]++;
            preCount[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (preCount[i] == 1) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                list.add(poll);
                if (map.containsKey(poll)) {
                    for (Integer next : map.get(poll)) {
                        preCount[next]--;
                        if (preCount[next] == 1) queue.add(next);
                    }
                }
            }
            res = list;
        }
        return res;
    }
}
