package ng2022.q0;

public class Q45 {
    public int jump(int[] nums) {
        int res = 0, curMax = 0, curLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curLen >= nums.length - 1) return res;
            curMax = Math.max(curMax, i + nums[i]);
            if (curLen == i) {
                curLen = curMax;
                res++;
            }
        }
        return -1;
    }
}
