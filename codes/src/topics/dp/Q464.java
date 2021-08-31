package topics.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        if (maxChoosableInteger >= desiredTotal) return true;
        Map<String, Boolean> memo = new HashMap<>();
        boolean[] visited = new boolean[maxChoosableInteger + 1];
        return helper(maxChoosableInteger, desiredTotal, memo, visited);
    }

    private boolean helper(int maxChoosableInteger, int desiredTotal, Map<String, Boolean> memo, boolean[] visited) {
        if (desiredTotal <= 0) return false;
        String s = Arrays.toString(visited);
        if (memo.containsKey(s)) return memo.get(s);
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (!helper(maxChoosableInteger, desiredTotal - i, memo, visited)) {
                memo.put(s, true);
                visited[i] = false;
                return true;
            }
            visited[i] = false;
        }
        memo.put(s, false);
        return false;
    }
}
