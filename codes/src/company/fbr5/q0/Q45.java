package company.fbr5.q0;

public class Q45 {
    public int jump(int[] nums) {
        int curMax = 0, curLen = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curLen >= nums.length - 1) return res;
            curMax = Math.max(curMax, i + nums[i]);
            if (i == curLen) {
                res++;
                curLen = curMax;
            }
        }
        return -1;
    }
}
