package company.fbr3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q1036 {
    static int dirs[][] = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static int limit = (int) 1e6;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blocks = new HashSet<>();
        for (int[] ints : blocked) {
            blocks.add(ints[0] + "," + ints[1]);
        }
        return helper(source, target, blocks) && helper(target, source, blocks);
    }

    private boolean helper(int[] source, int[] target, Set<String> blocks) {
        Set<String> visited = new HashSet<>();
        visited.add(source[0] + "," + source[1]);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            for (int dir[] : dirs) {
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];
                if (nextX < 0 || nextY < 0 || nextX >= limit || nextY >= limit) continue;
                String key = nextX + ":" + nextY;
                if (visited.contains(key) || blocks.contains(key)) continue;
                if (nextX == target[0] && nextY == target[1]) return true;
                queue.offer(new int[]{nextX, nextY});
                visited.add(key);
            }
            if (visited.size() == 20000) return true;
        }
        return false;
    }
}
