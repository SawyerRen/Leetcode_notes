package company.fb2;

import java.util.Arrays;
import java.util.List;

public class Q139 {
    public boolean wordBreak(String s, List<String> wordDict) {
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

    public static String wordBreak1(String s, List<String> wordDict) {
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
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            builder.append(s.charAt(i - 1));
            if (dp[i]) builder.append(" ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> list = Arrays.asList("cat", "and", "og", "cats", "an", "dog");
        System.out.println(wordBreak1(s, list));
    }
}
