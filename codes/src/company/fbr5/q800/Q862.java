package company.fbr5.q800;

import java.util.LinkedList;

public class Q862 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int res = Integer.MAX_VALUE;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n + 1; i++) {
            while (!list.isEmpty() && preSum[i] <= preSum[list.peekLast()]) {
                list.pollLast();
            }
            while (!list.isEmpty() && preSum[i] >= preSum[list.peekFirst()] + k) {
                res = Math.min(res, i - list.pollFirst());
            }
            list.addLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
