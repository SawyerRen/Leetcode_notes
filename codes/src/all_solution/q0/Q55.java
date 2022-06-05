package all_solution.q0;

public class Q55 {
    public boolean canJump(int[] nums) {
        int curMax = 0, curEnd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curEnd >= nums.length - 1) return true;
            curMax = Math.max(curMax, i + nums[i]);
            if (curEnd == i) {
                if (curMax == i) return false;
                curEnd = curMax;
            }
        }
        return false;
    }
}
