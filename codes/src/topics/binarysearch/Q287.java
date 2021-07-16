package topics.binarysearch;

import java.util.Arrays;

public class Q287 {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }
            if (count > mid) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
