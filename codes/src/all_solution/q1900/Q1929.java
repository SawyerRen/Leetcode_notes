package all_solution.q1900;

public class Q1929 {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] res = new int[2 * n];
        for (int i = 0; i < n; i++) {
            res[i] = res[n + i] = nums[i];
        }
        return res;
    }
}
