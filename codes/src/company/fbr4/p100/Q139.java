package company.fbr4.p100;

import java.util.List;

public class Q139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (String word : wordDict) {
                if (i >= word.length() && s.startsWith(word, i - word.length())) {
                    dp[i] = dp[i] | dp[i - word.length()];
                }
            }
        }
        return dp[n];
    }
}
