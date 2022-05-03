package all_solution.q1400;

public class Q1470 {
    public int[] shuffle(int[] nums, int n) {
        int i = 0, j = n, index = 0;
        int[] res = new int[nums.length];
        while (i < n) {
            res[index++] = nums[i++];
            res[index++] = nums[j++];
        }
        return res;
    }
}
