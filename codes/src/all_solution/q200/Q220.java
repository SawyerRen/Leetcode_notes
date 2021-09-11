package all_solution.q200;

import java.util.TreeSet;

public class Q220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 维持一个size=k的treeSet，每次寻找遍历到的数的相近值，如果相差小于等于t，返回true
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long n = (long) nums[i];
            Long floor = set.floor(n);
            Long ceiling = set.ceiling(n);
            if (floor != null && n - floor <= t) return true;
            if (ceiling != null && ceiling - n <= t) return true;
            set.add(n);
            if (set.size() > k) set.remove((long) nums[i - k]);
        }
        return false;
    }
}
