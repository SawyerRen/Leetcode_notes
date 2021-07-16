package topics.hashtable;

import java.util.HashMap;

public class Q325 {
    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0;
        // 前缀和数组
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        // map保存前缀和和对应的index
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(preSum[0], 0);
        for (int i = 1; i < preSum.length; i++) {
            if (map.containsKey(preSum[i] - k)) {
                res = Math.max(res, i - map.get(preSum[i] - k));
            }
            if (!map.containsKey(preSum[i])) {
                map.put(preSum[i], i);
            }
        }
        return res;
    }
}
