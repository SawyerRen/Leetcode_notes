package company.facebook;

import java.util.Arrays;

public class Q259 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < target) {
                    res += r - l;
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
