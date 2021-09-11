package all_solution.q200;

import java.util.LinkedList;
import java.util.Queue;

public class Q207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preCount = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            preCount[prerequisite[0]]++;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < preCount.length; i++) {
            if (preCount[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == course) {
                    preCount[prerequisite[0]]--;
                    if (preCount[prerequisite[0]] == 0) {
                        queue.add(prerequisite[0]);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
}
