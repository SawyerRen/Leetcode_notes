package all_solution.q400;

public class Q453 {
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(num, min);
        }
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }
}
