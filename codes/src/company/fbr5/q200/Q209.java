package company.fbr5.q200;

public class Q209 {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE, i = 0, j = 0, sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
