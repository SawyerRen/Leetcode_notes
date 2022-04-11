package all_solution.q1300;

import java.util.LinkedList;
import java.util.Queue;

public class Q1306 {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (arr[poll] == 0) return true;
            for (int i = 0; i < 2; i++) {
                int next = i == 0 ? poll + arr[poll] : poll - arr[poll];
                if (next < 0 || next >= arr.length || visited[next]) continue;
                queue.add(next);
                visited[next] = true;
            }
        }
        return false;
    }
}
