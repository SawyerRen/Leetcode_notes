package company.fbr4.q200;

import java.util.*;

public class Q207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preCount = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            preCount[prerequisite[0]]++;
            map.putIfAbsent(prerequisite[1], new HashSet<>());
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < preCount.length; i++) {
            if (preCount[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            count++;
            if (map.containsKey(poll)) {
                for (Integer c2 : map.get(poll)) {
                    preCount[c2]--;
                    if (preCount[c2] == 0) {
                        queue.add(c2);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
