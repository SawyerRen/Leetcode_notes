package company.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> (a[1] - b[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        int load = 0;
        int index = 0;
        for (int i = 0; i < 1001; i++) {
            while (!pq.isEmpty() && pq.peek()[2] <= i) {
                load -= pq.poll()[0];
            }
            while (index < trips.length && trips[index][1] == i) {
                load += trips[index][0];
                pq.add(trips[index++]);
            }
            if (load > capacity) return false;
        }
        return true;
    }

    public boolean carPooling1(int[][] trips, int capacity) {
        int[] count = new int[1001];
        for (int[] trip : trips) {
            count[trip[1]] += trip[0];
            count[trip[2]] -= trip[0];
        }
        int load = 0;
        for (int i = 0; i < 1001; i++) {
            load += count[i];
            if (load > capacity) return false;
        }
        return true;
    }
}
