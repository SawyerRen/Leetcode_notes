package company.fbr5.again;

import java.util.HashSet;
import java.util.Set;

public class Q548 {
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
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
                if (preSum[n - 1] - preSum[k] == preSum[k - 1] - preSum[j]) {
                    if (set.contains(preSum[n - 1] - preSum[k])) return true;
                }
            }
        }
        return false;
    }
}
