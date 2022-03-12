package all_solution.q400;

public class Q487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, i = 0, j = 0, count = 0;
        while (j < nums.length) {
            if (nums[j] == 0) count++;
            while (count > 1) {
                if (nums[i] == 0) count--;
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
