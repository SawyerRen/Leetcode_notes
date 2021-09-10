package all_solution.q300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> list = new ArrayList<>();
        int[] preCount = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            preCount[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < preCount.length; i++) {
            if (preCount[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            list.add(course);
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == course) {
                    preCount[prerequisite[0]]--;
                    if (preCount[prerequisite[0]] == 0) {
                        queue.add(prerequisite[0]);
                    }
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        if (res.length == numCourses) return res;
        return new int[0];
    }
}
