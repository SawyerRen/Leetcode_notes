package company.fbr3;

import java.util.List;

public class Q139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (String word : wordDict) {
                if (i >= word.length() && s.startsWith(word, i - word.length())) {
                    dp[i] = dp[i] || dp[i - word.length()];
                }
            }
        }
        return dp[s.length()];
    }
}
