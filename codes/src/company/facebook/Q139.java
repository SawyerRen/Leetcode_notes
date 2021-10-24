package company.facebook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (String word : wordDict) {
                if (i >= word.length() && s.startsWith(word, i - word.length())) {
                    dp[i] |= dp[i - word.length()];
                }
            }
        }
        return dp[s.length()];
    }

    public static String wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (String word : wordDict) {
                if (i >= word.length() && s.startsWith(word, i - word.length())) {
                    dp[i] |= dp[i - word.length()];
                }
            }
        }
        if (!dp[s.length()]) return "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i));
            if (dp[i + 1]) builder.append(" ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> words = Arrays.asList("apple","pen");
        System.out.println(wordBreak1(s, words));
    }
}
