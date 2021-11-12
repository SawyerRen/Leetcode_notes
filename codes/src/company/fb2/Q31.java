package company.fb2;

public class Q31 {
    public void nextPermutation(int[] nums) {
        int k = nums.length - 2;
        while (k >= 0 && nums[k] >= nums[k + 1]) k--;
        if (k < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int r = nums.length - 1;
        while (nums[r] <= nums[k]) r--;
        swap(nums, k, r);
        reverse(nums, k + 1, nums.length - 1);
    }

    void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
