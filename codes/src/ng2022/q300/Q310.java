package ng2022.q300;

import java.util.*;

public class Q310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] preCount = new int[n];
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            preCount[edge[0]]++;
            preCount[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < preCount.length; i++) {
            if (preCount[i] == 1) queue.add(i);
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.clear();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                res.add(poll);
                if (map.containsKey(poll)) {
                    for (Integer num : map.get(poll)) {
                        preCount[num]--;
                        if (preCount[num] == 1) {
                            queue.add(num);
                        }
                    }
                }
            }
        }
        return res;
    }
}
