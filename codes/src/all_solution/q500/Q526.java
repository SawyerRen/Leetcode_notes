package all_solution.q500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q526 {
    public int countArrangement(int n) {
        Map<String, Integer> memo = new HashMap<>();
        boolean[] visited = new boolean[n + 1];
        return helper(0, visited, n, memo);
    }

    private int helper(int count, boolean[] visited, int n, Map<String, Integer> memo) {
        if (count == n) {
            return 1;
        }
        String s = Arrays.toString(visited);
        if (memo.containsKey(s)) return memo.get(s);
        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) continue;
            if (i % (count + 1) != 0 && (count + 1) % i != 0) continue;
            visited[i] = true;
            res += helper(count + 1, visited, n, memo);
            visited[i] = false;
        }
        memo.put(s, res);
        return res;
    }
}
