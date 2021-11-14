package company.fbr5.again;

import java.util.LinkedList;

public class Q862 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        LinkedList<Integer> list = new LinkedList<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < preSum.length; i++) {
            while (!list.isEmpty() && preSum[i] < preSum[list.getLast()]) {
                list.removeLast();
            }
            while (!list.isEmpty() && preSum[i] - preSum[list.getFirst()] >= k) {
                res = Math.min(i - list.removeFirst(), res);
            }
            list.addLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
