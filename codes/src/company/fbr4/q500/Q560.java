package company.fbr4.q500;

import java.util.HashMap;
import java.util.Map;

public class Q560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
