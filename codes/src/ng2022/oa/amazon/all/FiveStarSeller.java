package ng2022.oa.amazon.all;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FiveStarSeller {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            double xDiff = (double) (x[0] + 1) / (x[1] + 1) - (double) x[0] / x[1];
            double yDiff = (double) (y[0] + 1) / (y[1] + 1) - (double) y[0] / y[1];
            return xDiff > yDiff? -1 : 1;
        });
        pq.addAll(Arrays.asList(classes));
        for (int i = 0; i < extraStudents; i++) {
            int[] c = pq.poll();
            c[0]++;
            c[1]++;
            pq.offer(c);
        }
        double res = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            res += (double) poll[0] / poll[1];
        }
        return res / classes.length;
    }
}
