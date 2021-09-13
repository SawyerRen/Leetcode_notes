package all_solution.q200;

import java.util.*;

public class Q279 {
    public int numSquares(int n) {
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(n);
        visited[n] = true;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer num = queue.poll();
                List<Integer> list = getSquares(num);
                for (Integer square : list) {
                    int next = num - square;
                    if (next == 0) return res;
                    if (visited[next]) continue;
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        return res;
    }

    private List<Integer> getSquares(Integer num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            list.add(i * i);
        }
        return list;
    }

    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
