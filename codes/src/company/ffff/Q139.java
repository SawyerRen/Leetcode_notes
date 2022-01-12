package company.ffff;

import java.util.List;

public class Q139 {
    public boolean wordBreak1(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (String word : wordDict) {
                if (i >= word.length() && s.startsWith(word, i - word.length())) {
                    dp[i] |= dp[i - word.length()];
                }
            }
        }
        return dp[n];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length() + 1];
        return helper(memo, s, 0, wordDict);
    }

    private boolean helper(Boolean[] memo, String s, int i, List<String> wordDict) {
        if (i == s.length()) return true;
        if (memo[i] != null) return memo[i];
        boolean res = false;
        for (String word : wordDict) {
            if (s.startsWith(word, i)) {
                res |= helper(memo, s, i + word.length(), wordDict);
            }
        }
        memo[i] = res;
        return res;
    }
}
