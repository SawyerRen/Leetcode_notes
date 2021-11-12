package company.fb2;

import java.util.HashMap;
import java.util.Map;

public class Q691 {
    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        int[][] count = new int[n][26];
        Map<String, Integer> memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                count[i][c - 'a']++;
            }
        }
        memo.put("", 0);
        return helper(memo, count, target);
    }

    private int helper(Map<String, Integer> memo, int[][] count, String target) {
        if (memo.containsKey(target)) return memo.get(target);
        int res = Integer.MAX_VALUE, n = count.length;
        int[] targetCount = new int[26];
        for (char c : target.toCharArray()) {
            targetCount[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (count[i][target.charAt(0) - 'a'] == 0) continue;
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (targetCount[j] > 0) {
                    for (int k = 0; k < Math.max(0, targetCount[j] - count[i][j]); k++) {
                        builder.append((char) (j + 'a'));
                    }
                }
            }
            String s = builder.toString();
            int next = helper(memo, count, s);
            if (next != -1) res = Math.min(res, next + 1);
        }
        memo.put(target, res == Integer.MAX_VALUE ? -1 : res);
        return memo.get(target);
    }
}
