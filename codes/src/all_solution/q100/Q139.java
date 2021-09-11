package all_solution.q100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (String word : wordDict) {
                if (i >= word.length() && set.contains(s.substring(i - word.length(), i))) {
                    dp[i] = dp[i] || dp[i - word.length()];
                }
            }
        }
        return dp[n];
    }
}
