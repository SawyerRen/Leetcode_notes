package topics.array;

import java.util.HashSet;
import java.util.Set;

public class Q128 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curLen = 1;
                while (num != Integer.MAX_VALUE && set.contains(num + 1)) {
                    curLen++;
                    num++;
                }
                res = Math.max(res, curLen);
            }
        }
        return res;
    }
}
