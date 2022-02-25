package all_solution.q200;

public class Q287 {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index] < 0) return index;
            nums[index] = -Math.abs(nums[index]);
        }
        return -1;
    }
}
