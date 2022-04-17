package all_solution.q1300;

import java.util.*;

public class Q1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            if (i == headID) continue;
            map.putIfAbsent(manager[i], new HashSet<>());
            map.get(manager[i]).add(i);
        }
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{headID, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            res = Math.max(res, poll[1]);
            if (map.containsKey(poll[0])) {
                for (Integer next : map.get(poll[0])) {
                    queue.add(new int[]{next, poll[1] + informTime[poll[0]]});
                }
            }
        }
        return res;
    }
}
