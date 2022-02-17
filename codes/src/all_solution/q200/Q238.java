package all_solution.q200;

public class Q238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int left = 1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = left;
            left = left * nums[i];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right = right * nums[i];
        }
        return res;
    }
}
