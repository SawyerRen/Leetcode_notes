package topics.greedy;

public class Q45 {
    public int jump(int[] nums) {
        int curEnd = 0, curMax = 0;
        int res = 0;
        int i = 0;
        while (i < nums.length) {
            if (curEnd >= nums.length - 1) return res;
            res++;
            while (i <= curEnd) {
                int curLen = i + nums[i];
                if (curLen > curMax) {
                    curMax = curLen;
                }
                i++;
            }
            if (curEnd == curMax) return -1;
            curEnd = curMax;
        }
        return -1;
    }
}
