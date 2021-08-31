package topics.backtracking;

import java.util.Arrays;

public class Q473 {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0) return false;
        Arrays.sort(matchsticks);
        int length = sum / 4;
        return helper(matchsticks, length, new int[4], matchsticks.length - 1);
    }

    private boolean helper(int[] matchsticks, int target, int[] sum, int index) {
        if (index < 0) {
            return sum[0] == target && sum[1] == target && sum[2] == target;
        }
        for (int i = 0; i < 4; i++) {
            if (sum[i] + matchsticks[index] <= target) {
                sum[i] += matchsticks[index];
                if (helper(matchsticks, target, sum, index - 1)) return true;
                sum[i] -= matchsticks[index];
            }
        }
        return false;
    }
}
