package company.facebook;

import java.util.*;

public class Q347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Integer num : map.keySet()) {
            int count = map.get(num);
            if (buckets[count] == null) buckets[count] = new ArrayList<>();
            buckets[count].add(num);
        }
        List<Integer> list = new ArrayList<>();
        for (int count = buckets.length - 1; count >= 0; count--) {
            if (buckets[count] != null) {
                if (k >= buckets[count].size()) {
                    list.addAll(buckets[count]);
                    k -= buckets[count].size();
                } else {
                    while (k > 0) {
                        list.add(buckets[count].get(k));
                        k--;
                    }
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
