package all_solution.q1300;

public class Q1312 {
    public int minInsertions(String s) {
        int[][] memo = new int[s.length() + 1][s.length() + 1];
        return helper(memo, s, 0, s.length() - 1);
    }

    private int helper(int[][] memo, String s, int left, int right) {
        if (left >= right) return 0;
        if (memo[left][right] != 0) return memo[left][right];
        int res = 0;
        if (s.charAt(left) == s.charAt(right)) {
            res = helper(memo, s, left + 1, right - 1);
        } else {
            res = Math.min(helper(memo, s, left + 1, right), helper(memo, s, left, right - 1)) + 1;
        }
        memo[left][right] = res;
        return res;
    }
}
