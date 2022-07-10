package ng2022.q900;

public class Q977 {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1;
        int[] res = new int[nums.length];
        for (int k = nums.length - 1; k >= 0; k--) {
            if (Math.abs(nums[i]) < Math.abs(nums[j])) {
                res[k] = nums[j] * nums[j];
                j--;
            } else {
                res[k] = nums[i] * nums[i];
                i++;
            }
        }
        return res;
    }
}
