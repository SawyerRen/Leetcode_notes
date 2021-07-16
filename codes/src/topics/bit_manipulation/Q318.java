package topics.bit_manipulation;

import java.util.Arrays;

public class Q318 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                mask[i] |= (1 << (c - 'a'));
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
