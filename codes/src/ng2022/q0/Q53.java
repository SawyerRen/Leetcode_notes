package ng2022.q0;

public class Q53 {
    public int maxSubArray(int[] nums) {
        int res = nums[0], preSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curMax = Math.max(preSum, 0) + nums[i];
            res = Math.max(res, curMax);
            preSum = curMax;
        }
        return res;
    }
}
