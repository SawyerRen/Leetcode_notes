package company.fbfinal;

import java.util.List;

public class Q139 {
    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (String word : wordDict) {
                if (i >= word.length() && s.startsWith(word, i - word.length())) {
                    dp[i] = dp[i] | dp[i - word.length()];
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length() + 1];
        return helper(s, memo, 0, wordDict);
    }

    private boolean helper(String s, Boolean[] memo, int i, List<String> wordDict) {
        if (i == s.length()) return true;
        if (memo[i] != null) return memo[i];
        boolean res = false;
        for (String word : wordDict) {
            if (s.startsWith(word, i)) {
                res |= helper(s, memo, i + word.length(), wordDict);
            }
        }
        memo[i] = res;
        return res;
    }
}
