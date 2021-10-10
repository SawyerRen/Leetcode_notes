package company.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int preSum = 0;
        int res = 0;
        for (int num : nums) {
            preSum += num;
            if (preSum == k) res++;
            if (preSumMap.containsKey(preSum - k)) {
                res += preSumMap.get(preSum - k);
            }
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }
}
