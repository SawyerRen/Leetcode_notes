package all_solution.q0;

public class Q53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0], curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }
}
