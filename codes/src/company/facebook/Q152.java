package company.facebook;

public class Q152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int res = nums[0];
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * max, nums[i] * min));
            max = tempMax;
            res = Math.max(res, max);
        }
        return res;
    }
}
