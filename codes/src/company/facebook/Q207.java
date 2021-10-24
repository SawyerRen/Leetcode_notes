package company.facebook;

import java.util.*;

public class Q207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preCount = new int[numCourses];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            preCount[prerequisite[0]]++;
            graph.putIfAbsent(prerequisite[1], new HashSet<>());
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < preCount.length; i++) {
            if (preCount[i] == 0) {
                count++;
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (!graph.containsKey(poll)) continue;
            for (Integer course : graph.get(poll)) {
                preCount[course]--;
                if (preCount[course] == 0) {
                    count++;
                    queue.add(course);
                }
            }
        }
        return count == numCourses;
    }
}
