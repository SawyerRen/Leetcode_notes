package topics.math;

public class Q453 {
    public int minMoves(int[] nums) {
        int res = 0;
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }
}
