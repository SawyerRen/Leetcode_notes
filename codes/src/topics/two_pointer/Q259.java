package topics.two_pointer;

import java.util.Arrays;

public class Q259 {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) break;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < target) {
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
