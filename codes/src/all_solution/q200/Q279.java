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
                Integer poll = queue.poll();
                List<Integer> nextList = getNext(poll);
                for (Integer next : nextList) {
                    int num = poll - next;
                    if (num == 0) return res;
                    if (visited[num]) continue;
                    queue.add(num);
                    visited[num] = true;
                }
            }
        }
        return res;
    }

    private List<Integer> getNext(Integer val) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= val; i++) {
            if (i * i <= val) res.add(i * i);
        }
        return res;
    }
}
