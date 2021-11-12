package company.fbr5.q1000;

import java.util.HashMap;
import java.util.Map;

public class Q1027 {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length, res = 0;
        Map<Integer, Integer>[] maps = new Map[n];
        for (int i = 0; i < n; i++) {
            maps[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int len = maps[j].getOrDefault(diff, 1) + 1;
                res = Math.max(res, len);
                maps[i].put(diff, len);
            }
        }
        return res;
    }
}
