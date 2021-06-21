package topics.greedy;

public class Q55 {
    public boolean canJump(int[] nums) {
        int curEnd = 0, curMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curEnd >= nums.length - 1) return true;
            curMax = Math.max(curMax, i + nums[i]);
            if (i == curEnd) {
                if (curEnd == curMax) return false;
                curEnd = curMax;
            }
        }
        return false;
    }
}
