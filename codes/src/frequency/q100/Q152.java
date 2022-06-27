package frequency.q100;

public class Q152 {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMax = nums[0], curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int preMax = curMax;
            curMax = Math.max(nums[i], Math.max(curMax * nums[i], curMin * nums[i]));
            curMin = Math.min(nums[i], Math.min(preMax * nums[i], curMin * nums[i]));
            res = Math.max(res, curMax);
        }
        return res;
    }
}
