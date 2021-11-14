package company.fbr5.again;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1094 {
    public boolean carPooling1(int[][] trips, int capacity) {
        int[] buckets = new int[1001];
        for (int[] trip : trips) {
            buckets[trip[1]] += trip[0];
            buckets[trip[2]] -= trip[0];
        }
        int load = 0;
        for (int i = 0; i < 1001; i++) {
            load += buckets[i];
            if (load > capacity) return false;
        }
        return true;
    }

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int load = 0;
        for (int[] trip : trips) {
            while (!pq.isEmpty() && trip[1] >= pq.peek()[2]) {
                load -= pq.poll()[0];
            }
            pq.add(trip);
            load += trip[0];
            if (load > capacity) return false;
        }
        return true;
    }
}
