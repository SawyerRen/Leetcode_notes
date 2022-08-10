package ng2022.oa.amazon.high;

import java.util.HashMap;
import java.util.Map;

public class FindMiddleMaximumCapacity {
    static int findMiddleMaximumCapacity(int[] capacity) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : capacity) {
            map.putIfAbsent(value, 1);
            int n = (int) Math.sqrt(value);
            for (int i = 1; i <= n; i++) {
                if (value % i == 0) {
                    if (map.containsKey(i)) {
                        if (map.get(i) >= 2) res = Math.max(res, i);
                        map.put(value, Math.max(map.get(i) + 1, map.get(value)));
                    }
                    if (map.containsKey(value / i)) {
                        if (map.get(value / i) >= 2) res = Math.max(res, value / i);
                        map.put(value, Math.max(map.get(value / i) + 1, map.get(value)));
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 8, 3, 9, 27};
        System.out.println(findMiddleMaximumCapacity(nums));
        nums = new int[]{6, 18, 2, 36};
        System.out.println(findMiddleMaximumCapacity(nums));
    }
}
