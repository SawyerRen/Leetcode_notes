package all_solution.q600;

import java.util.HashMap;
import java.util.Map;

public class Q697 {
    public int findShortestSubArray(int[] nums) {
        int res = 0, max = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.putIfAbsent(nums[i], i);
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            if (countMap.get(nums[i]) > max) {
                res = i - indexMap.get(nums[i]) + 1;
                max = countMap.get(nums[i]);
            } else if ((countMap.get(nums[i]) == max)) {
                res = Math.min(res, i - indexMap.get(nums[i]) + 1);
            }
        }
        return res;
    }
}
