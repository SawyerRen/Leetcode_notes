package topics.sliding_window;

public class Q209 {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int i = 0, j = 0, sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            j++;
            while (sum >= target) {
                res = Math.min(res, j - i);
                sum -= nums[i];
                i++;
            }
        }
        if (res == Integer.MAX_VALUE) return 0;
        return res;
    }
}
