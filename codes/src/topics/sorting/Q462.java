package topics.sorting;

import java.util.Arrays;

public class Q462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int res = 0;
        while (left < right) {
            res += nums[right] - nums[left];
            left++;
            right--;
        }
        return res;
    }
}
