package all_solution.q2000;

import model.TreeNode;

import java.util.*;

public class Q2007 {
    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) return new int[0];
        int[] res = new int[changed.length / 2];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int v : changed) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        int index = 0;
        for (Integer num : map.keySet()) {
            if (map.get(num) > map.getOrDefault(num * 2, 0)) return new int[0];
            for (int i = 0; i < map.get(num); i++) {
                res[index++] = num;
                map.put(num * 2, map.get(num * 2) - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 6, 8};
        int[] res = findOriginalArray(nums);
    }
}
