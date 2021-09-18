package all_solution.q200;

import java.util.Arrays;

public class Q259 {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 2) return 0;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    res += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
