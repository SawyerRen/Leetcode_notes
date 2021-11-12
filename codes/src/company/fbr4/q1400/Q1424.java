package company.fbr4.q1400;

import java.util.*;

public class Q1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int maxKey = 0, count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int key = i + j;
                count++;
                maxKey = Math.max(maxKey, key);
                map.putIfAbsent(key, new LinkedList<>());
                map.get(key).addFirst(nums.get(i).get(j));
            }
        }
        int[] res = new int[count];
        int index = 0;
        for (int i = 0; i < maxKey + 1; i++) {
            LinkedList<Integer> list = map.get(i);
            while (!list.isEmpty()) res[index++] = list.removeFirst();
        }
        return res;
    }
}
