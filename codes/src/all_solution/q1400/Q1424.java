package all_solution.q1400;

import java.util.*;

public class Q1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int size = 0, maxIndex = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int index = i + j;
                maxIndex = Math.max(maxIndex, index);
                size++;
                map.putIfAbsent(index, new LinkedList<>());
                map.get(index).addFirst(nums.get(i).get(j));
            }
        }
        int[] res = new int[size];
        int i = 0;
        for (int j = 0; j <= maxIndex; j++) {
            List<Integer> list = map.get(j);
            for (Integer integer : list) {
                res[i++] = integer;
            }
        }
        return res;
    }
}
