package ng2022.oa.amazon.all;

import java.util.PriorityQueue;

public class AmazonFreshDeliveries {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> computeDist(b) - computeDist(a));
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) pq.poll();
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    int computeDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
