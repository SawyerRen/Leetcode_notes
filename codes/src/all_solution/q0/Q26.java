package all_solution.q0;

public class Q26 {
    public int removeDuplicates(int[] nums) {
        int resIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[resIndex++] = nums[i];
            }
        }
        return resIndex;
    }
}
