package company.fbr5.again;

import java.util.HashSet;
import java.util.Set;

public class Q128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int len = 1;
                while (set.contains(num + 1)) {
                    num++;
                    len++;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
