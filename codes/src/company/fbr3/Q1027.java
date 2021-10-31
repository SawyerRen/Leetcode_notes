package company.fbr3;

import java.util.HashMap;

public class Q1027 {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer>[] maps = new HashMap[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
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
