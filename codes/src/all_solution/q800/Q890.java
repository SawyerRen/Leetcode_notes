package all_solution.q800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) res.add(word);
        }
        return res;
    }

    private boolean match(String word, String pattern) {
        if (word.length() != pattern.length()) return false;
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        Arrays.fill(hash1, -1);
        Arrays.fill(hash2, -1);
        for (int i = 0; i < word.length(); i++) {
            int c1 = word.charAt(i);
            int c2 = pattern.charAt(i);
            if (hash1[c1 - 'a'] != hash2[c2 - 'a']) return false;
            hash1[c1 - 'a'] = i;
            hash2[c2 - 'a'] = i;
        }
        return true;
    }
}
