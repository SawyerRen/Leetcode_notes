package all_solution.q400;

import java.util.Arrays;

public class Q462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            res += nums[j] - nums[i];
            i++;
            j--;
        }
        return res;
    }
}
