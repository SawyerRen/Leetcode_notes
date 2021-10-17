package company.facebook;

public class Q724 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (preSum * 2 == sum - nums[i]) return i;
            preSum += nums[i];
        }
        return -1;
    }
}
