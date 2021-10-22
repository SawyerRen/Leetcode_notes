package company.facebook;

import java.util.*;

public class Q1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int maxKey = 0;
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                count++;
                int key = i + j;
                maxKey = Math.max(maxKey, key);
                map.putIfAbsent(key, new LinkedList<>());
                map.get(key).addFirst(nums.get(i).get(j));
            }
        }
        int[] res = new int[count];
        int index = 0;
        for (int i = 0; i <= maxKey; i++) {
            if (!map.containsKey(i)) continue;
            LinkedList<Integer> list = map.get(i);
            for (Integer val : list) {
                res[index++] = val;
            }
        }
        return res;
    }
}
