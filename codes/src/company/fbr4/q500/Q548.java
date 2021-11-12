package company.fbr4.q500;

import java.util.HashSet;
import java.util.Set;

public class Q548 {
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i] = sum;
        }
        for (int j = 3; j < nums.length - 3; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (preSum[i - 1] == preSum[j - 1] - preSum[i]) {
                    set.add(preSum[i - 1]);
                }
            }
            for (int k = j + 2; k < nums.length - 1; k++) {
                if (preSum[k - 1] - preSum[j] == preSum[n - 1] - preSum[k] &&
                        set.contains(preSum[k - 1] - preSum[j])) return true;
            }
        }
        return false;
    }
}
