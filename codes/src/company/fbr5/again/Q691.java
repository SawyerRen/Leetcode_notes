package company.fbr5.again;

import java.util.HashMap;
import java.util.Map;

public class Q691 {
    public int minStickers(String[] stickers, String target) {
        int[][] count = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                count[i][c - 'a']++;
            }
        }
        Map<String, Integer> map = new HashMap<>();
        return helper(count, target, map);
    }

    private int helper(int[][] count, String target, Map<String, Integer> map) {
        if (target.length() == 0) return 0;
        if (map.containsKey(target)) return map.get(target);
        int[] targetCount = new int[26];
        for (char c : target.toCharArray()) {
            targetCount[c - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i][target.charAt(0) - 'a'] == 0) continue;
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                int len = Math.max(0, targetCount[j] - count[i][j]);
                for (int k = 0; k < len; k++) {
                    builder.append((char) (j + 'a'));
                }
            }
            String s = builder.toString();
            int next = helper(count, s, map);
            if (next != -1) {
                res = Math.min(res, next + 1);
            }
        }
        map.put(target, res == Integer.MAX_VALUE ? -1 : res);
        return map.get(target);
    }
}
