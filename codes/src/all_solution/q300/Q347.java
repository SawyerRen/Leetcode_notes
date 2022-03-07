package all_solution.q300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] lists = new List[nums.length + 1];
        for (Integer num : map.keySet()) {
            Integer count = map.get(num);
            if (lists[count] == null) lists[count] = new ArrayList<>();
            lists[count].add(num);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i > 0; i--) {
            if (res.size() == k) break;
            if (lists[i] != null) {
                res.addAll(lists[i]);
            }
        }
        int[] ints = new int[k];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = res.get(i);
        }
        return ints;
    }
}
