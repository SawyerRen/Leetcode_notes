package all_solution.q800;

public class Q813 {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        double[][] memo = new double[n][k + 1];
        return helper(memo, preSum, nums, k, 0);
    }

    private double helper(double[][] memo, int[] preSum, int[] nums, int k, int start) {
        if (memo[start][k] != 0) return memo[start][k];
        if (k == 1) return (double) (preSum[nums.length] - preSum[start]) / (nums.length - start);
        double res = 0;
        for (int i = start; i + k <= nums.length; i++) {
            res = Math.max(res, (double) (preSum[i + 1] - preSum[start]) / (i - start + 1) +
                    helper(memo, preSum, nums, k - 1, i + 1));
        }
        memo[start][k] = res;
        return res;
    }
}
