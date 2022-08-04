package ng2022.oa.imc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfMoves {
    private final int[][] DIRECTIONS = new int[][]{{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

    public int minKnightMoves(int n, int startRow, int startCol, int endRow, int endCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});

        boolean[][] visited = new boolean[n][n];
        visited[startRow][startCol] = true;

        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int curX = cur[0];
                int curY = cur[1];
                if (curX == endRow && curY == endCol) {
                    return result;
                }

                for (int[] d : DIRECTIONS) {
                    int newX = curX + d[0];
                    int newY = curY + d[1];
                    if (newX >= 0 && newY >= 0 && newX < n && newY < n && !visited[newX][newY]) {
                        queue.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            result++;
        }
        return -1;
    }

    int moves(int n, int startRow, int endRow, int startCol, int endCol, int bishopRow, int bishopCol) {
        if (startRow == endRow && startCol == endRow) return 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol, 1, 0});
        boolean[][][] visited = new boolean[n][n][2];
        visited[startRow][startCol][1] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1], alive = poll[2], steps = poll[3];
            for (int[] d : DIRECTIONS) {
                int x = i + d[0], y = j + d[1];
                if (x == endRow && y == endCol) return steps + 1;
                alive = alive == 1 && (x != bishopRow || y != bishopCol) ? 1 : 0;
                if (0 <= x && x < n && 0 <= y && y < n && !visited[x][y][alive]
                        && (alive == 0 || Math.abs(x - bishopRow) != Math.abs(y - bishopCol))) {
                    queue.add(new int[]{x, y, alive, steps + 1});
                    visited[x][y][alive] = true;
                }
            }
        }
        return -1;
    }
}
