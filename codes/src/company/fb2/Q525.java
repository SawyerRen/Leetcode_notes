package company.fb2;

import java.util.HashMap;
import java.util.Map;

public class Q525 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(sum)) {
                res = Math.max(i - map.get(sum), res);
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
