package company.fb2;

import java.util.*;

public class Q310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] count = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            count[edge[0]]++;
            count[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) queue.add(i);
        }
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                list.add(poll);
                if (map.containsKey(poll)) {
                    for (Integer next : map.get(poll)) {
                        count[next]--;
                        if (count[next] == 1) queue.add(next);
                    }
                }
            }
            res = list;
        }
        return res;
    }
}
