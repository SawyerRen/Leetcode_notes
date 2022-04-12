package all_solution.q1300;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1353 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0, i = 0;
        for (int d = 1; d < 100001; d++) {
            while (!pq.isEmpty() && d > pq.peek()) {
                pq.poll();
            }
            while (i < events.length && events[i][0] == d) {
                pq.add(events[i++][1]);
            }
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }
        return res;
    }
}
