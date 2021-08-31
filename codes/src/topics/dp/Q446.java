package topics.dp;

import java.util.HashMap;
import java.util.Map;

public class Q446 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int res = 0;
        Map<Integer, Integer>[] maps = new Map[nums.length];
        for (int i = 0; i < nums.length; i++) {
            maps[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                if (diff <= Integer.MIN_VALUE || diff >= Integer.MAX_VALUE) continue;
                int d = (int) diff;
                int n1 = maps[i].getOrDefault(d, 0);
                int n2 = maps[j].getOrDefault(d, 0);
                res += n2;
                maps[i].put(d, n1 + n2 + 1);
            }
        }
        return res;
    }
}
