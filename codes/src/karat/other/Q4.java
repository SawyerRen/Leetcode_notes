package karat.other;

import java.util.ArrayList;
import java.util.List;

public class Q4 {
    List<String> q4(List<String> words, String w) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (canMake(word, w)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean canMake(String word, String w) {
        if (word.length() != w.length() + 1) return false;
        int[] hash1 = new int[26], hash2 = new int[26];
        for (int i = 0; i < w.length(); i++) {
            hash1[word.charAt(i) - 'a']++;
            hash2[w.charAt(i) - 'a']++;
        }
        hash1[word.charAt(word.length() - 1) - 'a']++;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (hash1[i] < hash2[i]) return false;
            if (hash1[i] == hash2[i]) continue;
            if (hash1[i] > hash2[i]) count += hash1[i] - hash2[i];
        }
        return count == 1;
    }
}
