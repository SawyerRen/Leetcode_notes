package all_solution.q1400;

public class Q1413 {
    public int minStartValue(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        int minSum = preSum[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
            minSum = Math.min(minSum, preSum[i]);
        }
        return minSum >= 1 ? 1 : 1 - minSum;
    }
}
