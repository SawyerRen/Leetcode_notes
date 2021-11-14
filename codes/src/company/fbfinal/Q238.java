package company.fbfinal;

public class Q238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 1;
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left *= nums[i - 1];
            res[i] = left;
        }
        int right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right *= nums[i + 1];
            res[i] *= right;
        }
        return res;
    }
}
