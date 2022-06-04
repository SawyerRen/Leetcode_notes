package all_solution.q0;

public class Q45 {
    public int jump(int[] nums) {
        int curMax = 0, curEnd = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curEnd >= nums.length - 1) return res;
            curMax = Math.max(curMax, i + nums[i]);
            if (i == curEnd) {
                res++;
                curEnd = curMax;
            }
        }
        return res;
    }
}
