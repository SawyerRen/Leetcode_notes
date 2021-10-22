package company.facebook;

public class Q152 {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMax = nums[0], curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = Math.max(nums[i], Math.max(curMax * nums[i], curMin * nums[i]));
            curMin = Math.min(nums[i], Math.min(curMin * nums[i], curMax * nums[i]));
            curMax = max;
            res = Math.max(res, curMax);
        }
        return res;
    }
}
