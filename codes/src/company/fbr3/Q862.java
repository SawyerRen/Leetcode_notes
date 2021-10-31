package company.fbr3;

import java.util.Deque;
import java.util.LinkedList;

public class Q862 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        Deque<Integer> queue = new LinkedList<>();
        int res = n + 1;
        for (int i = 0; i < preSum.length; i++) {
            while (!queue.isEmpty() && preSum[i] <= preSum[queue.getLast()]) {
                queue.pollLast();
            }
            while (!queue.isEmpty() && preSum[i] >= preSum[queue.getFirst()] + k) {
                res = Math.min(res, i - queue.pollFirst());
            }
            queue.addLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
