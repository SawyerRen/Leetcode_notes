package company.fbr4.p0;

public class Q55 {
    public boolean canJump(int[] nums) {
        int curMax = 0, curLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curLen >= nums.length - 1) return true;
            curMax = Math.max(curMax, i + nums[i]);
            if (curLen == i) {
                if (curMax == i) return false;
                curLen = curMax;
            }
        }
        return false;
    }
}
