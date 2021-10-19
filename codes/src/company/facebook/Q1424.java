package company.facebook;

import java.util.*;

public class Q1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int maxKey = 0, count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int key = i + j;
                maxKey = Math.max(maxKey, key);
                map.putIfAbsent(key, new LinkedList<>());
                map.get(key).addFirst(nums.get(i).get(j));
                count++;
            }
        }
        int[] res = new int[count];
        int index = 0;
        for (int i = 0; i <= maxKey; i++) {
            LinkedList<Integer> linkedList = map.get(i);
            while (!linkedList.isEmpty()) {
                res[index++] = linkedList.pollFirst();
            }
        }
        return res;
    }
}
