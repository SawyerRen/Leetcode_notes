package company.fbr3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> (a[1] - b[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        int load = 0;
        for (int[] trip : trips) {
            while (!pq.isEmpty() && pq.peek()[2] <= trip[1]) {
                load -= pq.poll()[0];
            }
            pq.add(trip);
            load += trip[0];
            if (load > capacity) return false;
        }
        return true;
    }
}
