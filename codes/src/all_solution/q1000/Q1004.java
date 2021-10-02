package all_solution.q1000;

public class Q1004 {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0;
        int res = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[i] == 0) {
                    k++;
                }
                i++;
            }
            j++;
            res = Math.max(res, j - i);
        }
        return res;
    }
}
