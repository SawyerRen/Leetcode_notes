package all_solution.q1400;

import java.util.HashMap;
import java.util.Map;

public class Q1477 {
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int len1 = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            map.put(sum, i);
        }
        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                len1 = Math.min(len1, i - map.get(sum - target));
            }
            if (len1 != Integer.MAX_VALUE && map.containsKey(sum + target)) {
                res = Math.min(res, len1 + map.get(sum + target) - i);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
