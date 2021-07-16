package topics.array;

public class Q238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = nums[0];
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i];
        }
        right[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }
        int[] res = new int[len];
        res[0] = right[1];
        res[len - 1] = left[len - 2];
        for (int i = 1; i < len - 1; i++) {
            res[i] = left[i - 1] * right[i + 1];
        }
        return res;
    }
}
