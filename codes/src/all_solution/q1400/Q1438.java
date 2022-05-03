package all_solution.q1400;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Q1438 {
    public int longestSubarray(int[] nums, int limit) {
        int i = 0, j = 0, res = 0;
        LinkedList<Integer> maxList = new LinkedList<>();
        LinkedList<Integer> minList = new LinkedList<>();
        while (j < nums.length) {
            while (!maxList.isEmpty() && nums[j] > maxList.peekLast()) maxList.pollLast();
            while (!minList.isEmpty() && nums[j] < minList.peekLast()) minList.pollLast();
            maxList.addLast(nums[j]);
            minList.addLast(nums[j]);
            while (maxList.peekFirst() - minList.peekFirst() > limit) {
                if (maxList.peekFirst() == nums[i]) maxList.pollFirst();
                if (minList.peekFirst() == nums[i]) minList.pollFirst();
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }

    public int longestSubarray1(int[] nums, int limit) {
        int res = 0, i = 0, j = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (i < j && map.lastKey() - map.firstKey() > limit) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
