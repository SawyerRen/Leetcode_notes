package all_solution.q1400;

import java.util.HashMap;
import java.util.Map;

public class Q1416 {
    int mod = 1000000007;

    public int numberOfArrays(String s, int k) {
        Map<Integer, Integer> memo = new HashMap<>();
        return helper(memo, s, k, 0);
    }

    private int helper(Map<Integer, Integer> memo, String s, int k, int index) {
        if (s.length() == index) return 1;
        if (memo.containsKey(index)) return memo.get(index);
        int res = 0;
        long sub = 0;
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(index) == '0') break;
            sub = sub * 10 + s.charAt(i) - '0';
            if (sub > k) break;
            res = (res + helper(memo, s, k, i + 1)) % mod;
        }
        memo.put(index, res);
        return res;
    }
}
