package topics.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] preCount = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            preCount[prerequisite[0]]++;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < preCount.length; i++) {
            if (preCount[i] == 0) {
                res[count] = i;
                count++;
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == course) {
                    preCount[prerequisite[0]]--;
                    if (preCount[prerequisite[0]] == 0) {
                        res[count] = prerequisite[0];
                        count++;
                        queue.add(prerequisite[0]);
                    }
                }
            }
        }
        if (count < numCourses) return new int[]{};
        return res;
    }
}
