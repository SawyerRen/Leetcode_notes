package company.fbr5.q1300;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int maxKey = 0, count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int key = i + j;
                maxKey = Math.max(maxKey, key);
                count++;
                map.putIfAbsent(key, new LinkedList<>());
                map.get(key).addLast(nums.get(i).get(j));
            }
        }
        int[] res = new int[count];
        count = 0;
        for (int i = 0; i <= maxKey; i++) {
            LinkedList<Integer> list = map.get(i);
            while (!list.isEmpty()) {
                res[count++] = list.removeLast();
            }
        }
        return res;
    }
}
