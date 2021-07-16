package topics.design;

public class Q303 {
}

class NumArray {
    int[] preSum;

    public NumArray(int[] nums) {
        int n = nums.length;
        preSum = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}