package topics.dp;

import java.util.*;

public class Q472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Set<String> preWords = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (canForm(word, preWords)) {
                res.add(word);
            }
            preWords.add(word);
        }
        return res;
    }

    private boolean canForm(String word, Set<String> preWords) {
        if (preWords.isEmpty()) return false;
        int len = word.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i] || (dp[j] && preWords.contains(word.substring(j, i)));
            }
        }
        return dp[len];
    }
}
