package company.facebook;

import java.util.*;

public class Q398 {
}

class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Random random = new Random();

    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }
}
