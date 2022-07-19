package ng2022.q900;

import java.util.HashMap;
import java.util.Map;

public class Q974 {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum = (sum + num) % k;
            if (sum < 0) sum += k;
            res += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
