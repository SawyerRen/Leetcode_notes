package all_solution.q1600;

import java.util.PriorityQueue;

public class Q1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int remain = bricks;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i + 1] > heights[i]) {
                int diff = heights[i + 1] - heights[i];
                pq.add(diff);
                remain -= diff;
                if (remain < 0) {
                    if (ladders == 0) return i;
                    ladders--;
                    remain += pq.poll();
                }
            }
        }
        return heights.length - 1;
    }
}
