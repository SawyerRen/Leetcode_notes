package all_solution.q600;

import java.util.Arrays;

public class Q611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int r = nums.length - 1; r >= 2; r--) {
            int l = 0, m = r - 1;
            while (l < m) {
                if (nums[l] + nums[m] > nums[r]) {
                    res += m - l;
                    m--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }

    public int triangleNumber1(int[] nums) {
        int res = 0;
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 2; j < nums.length; j++) {
                int left = i + 1, right = j - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (nums[j] < nums[mid] + nums[i]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                if (left < j && nums[j] < nums[left] + nums[i]) {
                    res += j - left;
                }
            }
        }
        return res;
    }
}
