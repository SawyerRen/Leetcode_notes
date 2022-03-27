package all_solution.q1000;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1094 {
    public boolean carPooling(int[][] trips, int capacity) {
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

    public boolean carPooling1(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int count = 0;
        for (int[] trip : trips) {
            while (!pq.isEmpty() && trip[1] >= pq.peek()[2]) {
                count -= pq.poll()[0];
            }
            pq.add(trip);
            count += trip[0];
            if (count > capacity) return false;
        }
        return true;
    }
}
