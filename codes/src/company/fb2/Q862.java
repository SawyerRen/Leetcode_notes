package company.fb2;

import java.util.LinkedList;

public class Q862 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < preSum.length; i++) {
            while (!queue.isEmpty() && preSum[i] <= preSum[queue.peekLast()]) {
                queue.pollLast();
            }
            while (!queue.isEmpty() && preSum[i] >= preSum[queue.peekFirst()] + k) {
                res = Math.min(res, i - queue.pollFirst());
            }
            queue.addLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
