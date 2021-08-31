package topics.math;

public class Q396 {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int preSum = 0;
        int res;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum += i * nums[i];
        }
        res = preSum;
        for (int i = nums.length - 1; i > 0; i--) {
            preSum = preSum + sum - nums[i] * nums.length;
            res = Math.max(res, preSum);
        }
        return res;
    }
}
