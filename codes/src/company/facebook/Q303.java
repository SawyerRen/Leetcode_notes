package company.facebook;

public class Q303 {
}

class NumArray {
    int[] preSum;

    public NumArray(int[] nums) {
        int n = nums.length;
        preSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}