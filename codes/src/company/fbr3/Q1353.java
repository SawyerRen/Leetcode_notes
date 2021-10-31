package company.fbr3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1353 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0, res = 0;
        for (int d = 0; d < 100001; d++) {
            while (!pq.isEmpty() && pq.peek() < d) {
                pq.poll();
            }
            while (index < events.length && events[index][0] == d) {
                pq.add(events[index++][1]);
            }
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }
        return res;
    }
}
