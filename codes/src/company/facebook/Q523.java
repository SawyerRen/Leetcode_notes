package company.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = k == 0 ? sum : sum % k;
            if (preSum.containsKey(mod)) {
                if (i - preSum.get(mod) >= 2) return true;
            }
            preSum.putIfAbsent(mod, i);
        }
        return false;
    }
}
