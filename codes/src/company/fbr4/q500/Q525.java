package company.fbr4.q500;

import java.util.HashMap;
import java.util.Map;

public class Q525 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            }
            map.putIfAbsent(sum, i);
        }
        return res;
    }
}
