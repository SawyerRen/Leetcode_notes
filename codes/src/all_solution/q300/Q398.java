package all_solution.q300;

import java.util.Random;

public class Q398 {
}

class Solution1 {
    int[] nums;
    Random random;

    public Solution1(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (random.nextInt(count) == 0) res = i;
            }
        }
        return res;
    }
}
