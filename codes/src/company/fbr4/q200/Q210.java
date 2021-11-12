package company.fbr4.q200;

import java.util.*;

public class Q210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] preCount = new int[numCourses];
        int[] res = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            preCount[prerequisite[0]]++;
            map.putIfAbsent(prerequisite[1], new HashSet<>());
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < preCount.length; i++) {
            if (preCount[i] == 0) queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer c1 = queue.poll();
            res[count++] = c1;
            if (map.containsKey(c1)) {
                for (Integer c2 : map.get(c1)) {
                    preCount[c2]--;
                    if (preCount[c2] == 0) {
                        queue.add(c2);
                    }
                }
            }
        }
        if (count == numCourses) return res;
        return new int[0];
    }
}
