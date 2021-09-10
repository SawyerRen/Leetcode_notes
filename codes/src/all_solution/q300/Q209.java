package all_solution.q300;

public class Q209 {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            j++;
            while (sum >= target) {
                sum -= nums[i];
                i++;
                minLen = Math.min(j - i + 1, minLen);
            }

        }
        if (minLen == Integer.MAX_VALUE) return 0;
        return minLen;
    }
}
