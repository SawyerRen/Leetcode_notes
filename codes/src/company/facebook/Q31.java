package company.facebook;

public class Q31 {
    public void nextPermutation(int[] nums) {
        int left = nums.length - 2;
        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }
        if (left < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int right = nums.length - 1;
        while (nums[right] <= nums[left]) right--;
        swap(nums, left, right);
        reverse(nums, left + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
