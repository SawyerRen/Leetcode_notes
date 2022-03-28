package all_solution.q1100;

import java.util.Arrays;

public class Q1160 {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for (char c : chars.toCharArray()) {
            count[c - 'a']++;
        }
        int res = 0;
        for (String word : words) {
            boolean valid = true;
            int[] temp = Arrays.copyOf(count, 26);
            for (char c : word.toCharArray()) {
                temp[c - 'a']--;
                if (temp[c - 'a'] < 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) res += word.length();
        }
        return res;
    }
}
