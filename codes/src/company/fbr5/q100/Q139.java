package company.fbr5.q100;

import model.TreeNode;

import java.util.List;

public class Q139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (String word : wordDict) {
                if (s.startsWith(word, i - word.length())) {
                    dp[i] = dp[i] | dp[i - word.length()];
                }
            }
        }
        return dp[n];
    }
}
