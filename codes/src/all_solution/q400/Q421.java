package all_solution.q400;

import java.util.HashSet;
import java.util.Set;

public class Q421 {
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int nextMax = res | (1 << i);
            for (Integer left : set) {
                if (set.contains(left ^ nextMax)) {
                    res = nextMax;
                    break;
                }
            }
        }
        return res;
    }
}
