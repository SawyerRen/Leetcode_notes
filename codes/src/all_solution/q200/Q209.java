package all_solution.q200;

public class Q209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, i = 0, j = 0, minLen = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            j++;
            while (sum >= target) {
                sum -= nums[i];
                i++;
                minLen = Math.min(minLen, j - i + 1);
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
