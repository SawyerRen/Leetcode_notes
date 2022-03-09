package all_solution.q300;

import java.util.Arrays;

public class Q376 {
    public int wiggleMaxLength(int[] nums) {
        int low = 1, high = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                high = low + 1;
            } else if (nums[i] < nums[i - 1]) {
                low = high + 1;
            }
        }
        return Math.max(low, high);
    }
}
