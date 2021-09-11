package all_solution.q100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q128 {
    public int longestConsecutive(int[] nums) {
        // 保存一段长度的左右数字和对应的这段长度
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int sum = left + 1 + right;
            res = Math.max(res, sum);
            map.put(num, sum);
            map.put(num - left, sum);
            map.put(num + right, sum);
        }
        return res;
    }

    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        int curLen = 1;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                curLen = 1;
                while (num != Integer.MAX_VALUE && set.contains(num + 1)) {
                    curLen++;
                    num++;
                }
            }
            res = Math.max(res, curLen);
        }
        return res;
    }
}
