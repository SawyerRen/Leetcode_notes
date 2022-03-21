package all_solution.q800;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int i = 0, count = 0, maxDist = startFuel;
        while (maxDist < target) {
            while (i < stations.length && maxDist >= stations[i][0]) {
                pq.add(stations[i++][1]);
            }
            if (pq.isEmpty()) return -1;
            maxDist += pq.poll();
            count++;
        }
        return count;
    }
}
