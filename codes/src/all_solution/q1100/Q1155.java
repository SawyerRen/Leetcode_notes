package all_solution.q1100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1155 {
    int mod = 1000000007;

    public int numRollsToTarget(int d, int f, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(memo, d, f, target);
    }

    private int helper(Map<String, Integer> memo, int d, int f, int target) {
        if (0 == target && d == 0) return 1;
        if (0 == target || d == 0) return 0;
        String state = d + " " + target;
        if (memo.containsKey(state)) return memo.get(state);
        int res = 0;
        for (int i = 1; i <= f; i++) {
            if (i <= target) {
                res = (res + helper(memo, d - 1, f, target - i)) % mod;
            } else {
                break;
            }
        }
        memo.put(state, res);
        return res;
    }
}
