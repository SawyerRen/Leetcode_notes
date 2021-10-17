package company.facebook;

import java.util.*;

public class Q207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preCount = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = graph.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            graph.put(prerequisite[1], list);
            preCount[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < preCount.length; i++) {
            if (preCount[i] == 0) {
                count++;
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            if (!graph.containsKey(course)) continue;
            for (Integer c : graph.get(course)) {
                preCount[c]--;
                if (preCount[c] == 0) {
                    queue.add(c);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}
