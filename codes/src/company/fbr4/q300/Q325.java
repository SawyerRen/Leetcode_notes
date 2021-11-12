package company.fbr4.q300;

import java.util.HashMap;
import java.util.Map;

public class Q325 {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                int index = map.get(sum - k);
                res = Math.max(res, i - index);
            }
            map.putIfAbsent(sum, i);
        }
        return res;
    }
}
