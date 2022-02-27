package all_solution.q300;

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
            int e1 = edge[0];
            int e2 = edge[1];
            map.putIfAbsent(e1, new HashSet<>());
            map.putIfAbsent(e2, new HashSet<>());
            map.get(e1).add(e2);
            map.get(e2).add(e1);
            count[e1]++;
            count[e2]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (count[i] == 1) queue.add(i);
        }
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer e1 = queue.poll();
                list.add(e1);
                for (Integer e2 : map.get(e1)) {
                    count[e2]--;
                    if (count[e2] == 1) queue.add(e2);
                }
            }
            res = list;
        }
        return res;
    }
}
