package all_solution.q200;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Q219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int left = map.get(nums[i]);
                if (i - left <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
