package all_solution.q500;

import model.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

public class Q505 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int[][] distance = new int[m][n];
        for (int[] ints : distance) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        queue.add(new int[]{start[0], start[1], 0});
        distance[start[0]][start[1]] = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == destination[0] && poll[1] == destination[1]) return poll[2];
            for (int[] dir : dirs) {
                int step = poll[2];
                int x = poll[0] + dir[0], y = poll[1] + dir[1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    step++;
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if (distance[x][y] <= step) continue;
                queue.add(new int[]{x, y, step});
                distance[x][y] = step;
            }
        }
        return -1;
    }
}
