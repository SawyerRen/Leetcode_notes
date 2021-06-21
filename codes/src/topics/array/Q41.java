package topics.array;

public class Q41 {
    public int firstMissingPositive(int[] nums) {
        boolean hasOne = false;
        for (int num : nums) {
            if (num == 1) {
                hasOne = true;
                break;
            }
        }
        if (!hasOne) return 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) == nums.length) nums[0] = -Math.abs(nums[0]);
            else {
                int index = Math.abs(nums[i]);
                nums[index] = -Math.abs(nums[index]);
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) return i;
        }
        if (nums[0] > 0) return nums.length;
        return nums.length + 1;
    }
}
