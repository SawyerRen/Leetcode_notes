package company.fbr5.q600;

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
        map.put("", 0);
        return helper(map, count, target);
    }

    private int helper(Map<String, Integer> map, int[][] count, String target) {
        if (map.containsKey(target)) return map.get(target);
        int[] targetCount = new int[26];
        for (char c : target.toCharArray()) {
            targetCount[c - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            StringBuilder builder = new StringBuilder();
            if (count[i][target.charAt(0) - 'a'] == 0) continue;
            for (int j = 0; j < 26; j++) {
                int len = Math.max(0, targetCount[j] - count[i][j]);
                for (int k = 0; k < len; k++) {
                    builder.append((char) (j + 'a'));
                }
            }
            int next = helper(map, count, builder.toString());
            if (next != -1) res = Math.min(res, next + 1);
        }
        map.put(target, res == Integer.MAX_VALUE ? -1 : res);
        return map.get(target);
    }
}
