package all_solution;

public class Q41 {
    public int firstMissingPositive(int[] nums) {
        // 判断有没有1
        boolean hasOne = false;
        for (int num : nums) {
            if (num == 1) {
                hasOne = true;
                break;
            }
        }
        if (!hasOne) return 1;
        // 超出[1,n]范围的都置为1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) nums[i] = 1;
        }
        // 将出现的数作为index 置为负数
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (index == nums.length) nums[0] = -Math.abs(nums[0]);
            else {
                nums[index] = -Math.abs(nums[index]);
            }
        }
        // 如果出现正数，说明这个index没有出现过
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > 0) return i;
        }
        if (nums[0] > 0) return nums.length;
        return nums.length + 1;
    }
}
