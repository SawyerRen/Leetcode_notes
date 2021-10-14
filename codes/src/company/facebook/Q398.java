package company.facebook;

import java.util.*;

public class Q398 {
    int[] nums;
    Random random;

    public Q398(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int index = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (random.nextInt(++count) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }
}
