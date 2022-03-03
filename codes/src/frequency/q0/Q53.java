package frequency.q0;

public class Q53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = nums[0], pre = nums[0];
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            if (pre > 0) cur += pre;
            res = Math.max(res, cur);
            pre = cur;
        }
        return res;
    }
}
