package all_solution;

public class Q45 {
    public int jump(int[] nums) {
        int res = 0;
        int curLen = 0;
        int curMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curLen >= nums.length - 1) return res;
            curMax = Math.max(curMax, i + nums[i]);
            if (i == curLen) {
                res++;
                curLen = curMax;
            }
        }
        return res;
    }
}
