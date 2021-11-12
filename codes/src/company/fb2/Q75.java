package company.fb2;

public class Q75 {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, right, i);
                right--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int j, int i) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
