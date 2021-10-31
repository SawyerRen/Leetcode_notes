package company.fbr3;

public class Q209 {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, sum = 0;
        int res = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                res = Math.min(j - i + 1, res);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        if (res == Integer.MAX_VALUE) return 0;
        return res;
    }
}
