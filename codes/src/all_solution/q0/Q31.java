package all_solution.q0;

public class Q31 {
    public void nextPermutation(int[] nums) {
        int pivot = nums.length - 2;
        // 找到最大的满足nums[pivot] < nums[pivot + 1]的index
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
            pivot--;
        }
        // 如果pivot<0，说明整个array都是从右往左递减的，直接reverse整个数组
        if (pivot < 0) {
            reverse(nums, 0, nums.length - 1);
        } else {
            // 找到右边大于pivot上的数的最大index
            int r = nums.length - 1;
            while (nums[r] <= nums[pivot]) r--;
            // 交换
            swap(nums, pivot, r);
            // 翻转pivot之后的数组
            reverse(nums, pivot + 1, nums.length - 1);
        }
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
