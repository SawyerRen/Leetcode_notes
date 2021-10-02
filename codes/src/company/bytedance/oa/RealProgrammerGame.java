package company.bytedance.oa;

import java.util.HashMap;
import java.util.Map;

/*
Given an integer N indicating the health of a monster,
what is the probability that you will kill the monster by swinging sticks at the monster K times? With each swing,
you have the probability of reducing the monster by an evenly
distributed random number from 0 to M.
 */
public class RealProgrammerGame {
    static double solution(int n, int m, int k) {
        Map<String, Integer> memo = new HashMap<>();
        int count = helper(n, m, k, memo);
        System.out.println(count);
        double total = Math.pow(m + 1, k);
        System.out.println(total);
        return count / total;
    }

    private static int helper(int n, int m, int k, Map<String, Integer> memo) {
        if (n <= 0 && k == 0) return 1;
        if (k == 0) return 0;
        String state = n + "," + k;
        if (memo.containsKey(state)) return memo.get(state);
        int count = 0;
        for (int i = 0; i <= m; i++) {
            count += helper(n - i, m, k - 1, memo);
        }
        memo.put(state, count);
        return count;
    }
}
