package company.pimco;

import java.util.HashMap;
import java.util.Map;

// LC 697
//Given a non-empty array of non-negative integers nums, the degree of this
// array is defined as the maximum frequency of any one of its elements.
//
//Your task is to find the smallest possible length of a (contiguous) subarray of
// nums, that has the same degree as nums.
public class Q3 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        int max = 0, first = -1, res = 0;
        for (int i = 0; i < nums.length; i++) {
            indexMap.putIfAbsent(nums[i], i);
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            if (max < countMap.get(nums[i])) {
                max = countMap.get(nums[i]);
                first = indexMap.get(nums[i]);
                res = i - first + 1;
            } else if (max == countMap.get(nums[i])) {
                res = Math.min(res, i - indexMap.get(nums[i]) + 1);
            }
        }
        if (max == 0) return 0;
        return res;
    }
}
