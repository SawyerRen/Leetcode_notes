package all_solution.q2000;

public class Q2016 {
    public int maximumDifference(int[] nums) {
        int min = nums[0], res = -1;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - min);
            min = Math.min(min, nums[i]);
        }
        return res == 0 ? -1 : res;
    }
}
