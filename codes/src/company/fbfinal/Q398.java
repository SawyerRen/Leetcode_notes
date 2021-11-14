package company.fbfinal;

import java.util.*;

public class Q398 {
    class Solution {
        int[] nums;
        Random random = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int count = 0, res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    count++;
                    if (random.nextInt(count) == 0) res = i;
                }
            }
            return res;
        }
    }
}
