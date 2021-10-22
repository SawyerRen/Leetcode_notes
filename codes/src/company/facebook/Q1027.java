package company.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q1027 {
    public int longestArithSeqLength(int[] nums) {
        int res = 0;
        int n = nums.length;
        HashMap<Integer, Integer>[] maps = new HashMap[n];
        for (int i = 0; i < nums.length; i++) {
            maps[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                maps[i].put(diff, maps[j].getOrDefault(diff, 1) + 1);
                res = Math.max(res, maps[i].get(diff));
            }
        }
        return res;
    }
}
