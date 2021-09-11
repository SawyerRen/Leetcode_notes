package all_solution.q200;

public class Q238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) res[i] = 1;
            else res[i] = res[i - 1] * nums[i - 1];
        }
        int right = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] = res[i] * right;
            right = nums[i] * right;
        }
        return res;
    }
}
