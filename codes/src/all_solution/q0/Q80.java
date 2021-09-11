package all_solution.q0;

public class Q80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        int index = 2;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == nums[index - 2]) continue;
            nums[index++] = nums[i];
        }
        return index;
    }
}
