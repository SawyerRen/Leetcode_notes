package all_solution.q400;

public class Q485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int len = 1;
                while (i + 1 < nums.length && nums[i + 1] == 1) {
                    len++;
                    i++;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
