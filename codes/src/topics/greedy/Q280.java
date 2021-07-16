package topics.greedy;

public class Q280 {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // i为偶数时，需要小于下一个数
            if (i % 2 == 0) {
                if (nums[i] > nums[i + 1]) swap(nums, i, i + 1);
                // i为奇数时，需要大于下一个数
            } else {
                if (nums[i] < nums[i + 1]) swap(nums, i, i + 1);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
