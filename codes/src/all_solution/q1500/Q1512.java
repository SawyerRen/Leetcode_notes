package all_solution.q1500;

import java.util.HashMap;
import java.util.Map;

public class Q1512 {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Integer count : map.values()) {
            res += (count - 1) * count / 2;
        }
        return res;
    }
}
