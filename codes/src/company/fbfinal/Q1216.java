package company.fbfinal;

public class Q1216 {
    public boolean isValidPalindrome(String s, int k) {
        int[][] memo = new int[s.length()][s.length()];
        int count = helper(s, memo, 0, s.length() - 1);
        return count <= k;
    }

    private int helper(String s, int[][] memo, int left, int right) {
        if (left >= right) return 0;
        if (memo[left][right] != 0) return memo[left][right];
        int res = 0;
        if (s.charAt(left) == s.charAt(right)) {
            res = helper(s, memo, left + 1, right - 1);
        } else {
            res = Math.min(helper(s, memo, left + 1, right), helper(s, memo, left, right - 1)) + 1;
        }
        memo[left][right] = res;
        return res;
    }
}
