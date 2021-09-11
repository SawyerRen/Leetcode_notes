package all_solution.q100;

import java.util.Arrays;

public class Q164 {
    public int maximumGap(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int gap = (int) Math.ceil((double) (max - min) / nums.length);
        int[] minBuckets = new int[nums.length];
        int[] maxBuckets = new int[nums.length];
        Arrays.fill(minBuckets, Integer.MAX_VALUE);
        Arrays.fill(maxBuckets, Integer.MIN_VALUE);
        for (int num : nums) {
            if (num == min || num == max) continue;
            int index = (num - min) / gap;
            minBuckets[index] = Math.min(num, minBuckets[index]);
            maxBuckets[index] = Math.max(num, maxBuckets[index]);
        }
        int pre = min;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (minBuckets[i] == Integer.MAX_VALUE && maxBuckets[i] == Integer.MIN_VALUE) continue;
            res = Math.max(res, minBuckets[i] - pre);
            pre = maxBuckets[i];
        }
        res = Math.max(res, max - pre);
        return res;
    }
}
