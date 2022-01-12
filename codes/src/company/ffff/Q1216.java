package company.ffff;

public class Q1216 {
    public boolean isValidPalindrome(String s, int k) {
        int[][] memo = new int[s.length()][s.length()];
        int count = helper(memo, s, 0, s.length() - 1);
        return count <= k;
    }

    private int helper(int[][] memo, String s, int left, int right) {
        if (left > right) return 0;
        if (memo[left][right] != 0) return memo[left][right];
        int count = 0;
        if (s.charAt(left) == s.charAt(right)) {
            count = helper(memo, s, left + 1, right - 1);
        } else {
            count = Math.min(helper(memo, s, left + 1, right), helper(memo, s, left, right - 1)) + 1;
        }
        memo[left][right] = count;
        return count;
    }
}
