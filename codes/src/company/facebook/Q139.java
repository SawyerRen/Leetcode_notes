package company.facebook;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean[] memo = new Boolean[n + 1];
        return helper(s, new HashSet<>(wordDict), memo, 0);
    }

    private boolean helper(String s, HashSet<String> words, Boolean[] memo, int i) {
        if (i == s.length()) return true;
        if (memo[i] != null) return memo[i];
        boolean res = false;
        for (int j = i + 1; j <= s.length(); j++) {
            if (words.contains(s.substring(i, j))) {
                if (helper(s, words, memo, j)) {
                    res = true;
                    break;
                }
            }
        }
        memo[i] = res;
        return res;
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (String word : wordDict) {
                if (i >= word.length() && word.equals(s.substring(i - word.length(), i))) {
                    dp[i] |= dp[i - word.length()];
                }
            }
        }
        return dp[s.length()];
    }
}
