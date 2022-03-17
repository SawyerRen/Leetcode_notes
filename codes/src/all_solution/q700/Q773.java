package all_solution.q700;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q773 {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        for (int[] row : board) {
            for (int i : row) {
                start += i;
            }
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        int[][] dirs = new int[][]{{1, 3}, {0, 2, 4},
                {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(target)) return res;
                int zero = poll.indexOf('0');
                for (int pos : dirs[zero]) {
                    StringBuilder builder = new StringBuilder(poll);
                    builder.setCharAt(zero, builder.charAt(pos));
                    builder.setCharAt(pos, '0');
                    String next = builder.toString();
                    if (visited.contains(next)) continue;
                    queue.add(next);
                    visited.add(next);
                }
            }
            res++;
        }
        return -1;
    }
}
