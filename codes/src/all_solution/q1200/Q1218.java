package all_solution.q1200;

import java.util.*;

public class Q1218 {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : arr) {
            int pre = map.getOrDefault(num - difference, 0);
            map.put(num, pre + 1);
            res = Math.max(res, map.get(num));
        }
        return res;
    }
}
