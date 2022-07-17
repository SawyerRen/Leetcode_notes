package all_solution.q2300;

public class Q2341 {
    public int[] numberOfPairs(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        int total = nums.length;
        int pairCount = 0;
        for (int val : count) {
            pairCount += val / 2;
        }
        return new int[]{pairCount, total - 2 * pairCount};
    }
}
