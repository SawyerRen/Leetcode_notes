package all_solution.q400;

public class Q477 {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += (num >> i) & 1;
            }
        }
        for (int i = 0; i < 32; i++) {
            res += (nums.length - count[i]) * count[i];
        }
        return res;
    }
}
