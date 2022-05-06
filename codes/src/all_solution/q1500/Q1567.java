package all_solution.q1500;

public class Q1567 {
    public int getMaxLen(int[] nums) {
        int positive = 0, negative = 0;
        int res = 0;
        for (int num : nums) {
            if (num == 0) {
                positive = 0;
                negative = 0;
            } else if (num > 0) {
                positive++;
                negative = negative == 0 ? 0 : negative + 1;
            } else {
                int temp = positive;
                positive = negative == 0 ? 0 : negative + 1;
                negative = temp + 1;
            }
            res = Math.max(res, positive);
        }
        return res;
    }
}
