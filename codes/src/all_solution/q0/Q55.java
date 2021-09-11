package all_solution.q0;

public class Q55 {
    public boolean canJump(int[] nums) {
        int curMax = 0;
        int curLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curLen >= nums.length - 1) return true;
            curMax = Math.max(curMax, i + nums[i]);
            if (i == curLen) {
                if (i == curMax) return false;
                curLen = curMax;
            }
        }
        return false;
    }
}
