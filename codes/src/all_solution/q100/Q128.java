package all_solution.q100;

import java.util.*;

public class Q128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int curLen = 0, res = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                curLen = 1;
                while (set.contains(num + 1)) {
                    num++;
                    curLen++;
                }
                res = Math.max(res, curLen);
            }
        }
        return res;
    }
}
