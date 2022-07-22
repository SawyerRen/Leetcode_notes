package ng2022.q0;

public class Q55 {
    public boolean canJump(int[] nums) {
        int curMax = 0, curLen = 0;
        for (int i = 0; i < nums.length; i++) {
            curMax = Math.max(curMax, i + nums[i]);
            if (curMax >= nums.length - 1) return true;
            if (i == curLen) {
                if (curMax == i) return false;
                curLen = curMax;
            }
        }
        return true;
    }
}
