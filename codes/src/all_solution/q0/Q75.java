package all_solution.q0;

public class Q75 {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, index = 0;
        while (index <= right) {
            if (nums[index] == 1) {
                index++;
                continue;
            }
            if (nums[index] == 0) {
                int t = nums[index];
                nums[index] = nums[left];
                nums[left] = t;
                index++;
                left++;
            } else if (nums[index] == 2) {
                int t = nums[index];
                nums[index] = nums[right];
                nums[right] = t;
                right--;
            }
        }
    }
}
