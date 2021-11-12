package company.fb2;

import java.util.HashMap;
import java.util.Map;

public class Q325 {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res = Math.max(i - map.get(sum - k), res);
            }
            map.putIfAbsent(sum, i);
        }
        return res;
    }
}
