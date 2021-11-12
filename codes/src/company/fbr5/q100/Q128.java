package company.fbr5.q100;

import java.util.HashSet;
import java.util.Set;

public class Q128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0, curLen = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                set.remove(num);
                curLen = 1;
                while (set.remove(num + 1)) {
                    curLen++;
                    num++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
