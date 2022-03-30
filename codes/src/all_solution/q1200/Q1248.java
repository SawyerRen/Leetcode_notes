package all_solution.q1200;

public class Q1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int i = 0, j = 0, res = 0, count = 0;
        while (j < nums.length) {
            if (nums[j] % 2 != 0) {
                k--;
                count = 0;
            }
            while (k == 0) {
                k += nums[i] & 1;
                count++;
                i++;
            }
            res += count;
            j++;
        }
        return res;
    }
}
