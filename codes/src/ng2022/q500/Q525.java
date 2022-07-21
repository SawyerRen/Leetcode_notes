package ng2022.q500;

import java.util.HashMap;
import java.util.Map;

public class Q525 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int preSum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(preSum)) {
                res = Math.max(res, i - map.get(preSum));
            } else {
                map.put(preSum, i);
            }
        }
        return res;
    }
}
