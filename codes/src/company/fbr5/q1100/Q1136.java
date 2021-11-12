package company.fbr5.q1100;

import java.util.*;

public class Q1136 {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] preCount = new int[n + 1];
        for (int[] relation : relations) {
            preCount[relation[1]]++;
            map.putIfAbsent(relation[0], new HashSet<>());
            map.get(relation[0]).add(relation[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < preCount.length; i++) {
            if (preCount[i] == 0) {
                queue.add(i);
            }
        }
        int res = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer c1 = queue.poll();
                count++;
                if (map.containsKey(c1)) {
                    for (Integer c2 : map.get(c1)) {
                        preCount[c2]--;
                        if (preCount[c2] == 0) {
                            queue.add(c2);
                        }
                    }
                }
            }
        }
        if (count < n) return -1;
        return res;
    }
}
