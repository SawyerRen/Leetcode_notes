package company.fbr4.p100;

import java.util.HashSet;
import java.util.Set;

public class Q128 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int curNum = 0, curLen = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                curNum = num;
                curLen = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curLen++;
                }
                res = Math.max(res, curLen);
            }
        }
        return res;
    }
}
