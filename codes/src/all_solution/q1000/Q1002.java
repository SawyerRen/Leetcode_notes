package all_solution.q1000;

import java.util.ArrayList;
import java.util.List;

public class Q1002 {
    public List<String> commonChars(String[] words) {
        int[][] count = new int[words.length][26];
        List<String> res = new ArrayList<>();
        if (words.length == 0) return res;
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                count[i][c - 'a']++;
            }
        }
        for (int j = 0; j < 26; j++) {
            int minCount = count[0][j];
            for (int i = 0; i < count.length; i++) {
                minCount = Math.min(minCount, count[i][j]);
            }
            for (int i = 0; i < minCount; i++) {
                res.add(String.valueOf((char) (j + 'a')));
            }
        }
        return res;
    }
}
