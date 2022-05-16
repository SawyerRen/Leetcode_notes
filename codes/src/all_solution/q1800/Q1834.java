package all_solution.q1800;

import java.util.*;

public class Q1834 {
    public int[] getOrder(int[][] tasks) {
        List<Task> list = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) {
            list.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        list.sort(Comparator.comparingInt(a -> a.start));
        int[] res = new int[tasks.length];
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> a.duration == b.duration ? a.index - b.index : a.duration - b.duration);
        int time = 0, resIndex = 0, taskIndex = 0;
        while (resIndex < res.length) {
            while (taskIndex < list.size() && list.get(taskIndex).start <= time) {
                pq.add(list.get(taskIndex++));
            }
            if (pq.isEmpty()) {
                time = list.get(taskIndex).start;
                continue;
            }
            Task task = pq.poll();
            res[resIndex++] = task.index;
            time += task.duration;
        }
        return res;
    }

    private static class Task {
        int index;
        int start;
        int duration;

        public Task(int index, int start, int duration) {
            this.index = index;
            this.start = start;
            this.duration = duration;
        }
    }
}
