package company.fbr4.again;

import java.util.LinkedList;
import java.util.Queue;

public class Q529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1];
            if (board[i][j] == 'M') {
                board[i][j] = 'X';
            } else {
                int count = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        if (k == 0 && l == 0) continue;
                        int x = i + k, y = j + l;
                        if (x < 0 || x >= m || y < 0 || y >= n) continue;
                        if (board[i + k][j + l] == 'X' || board[i + k][j + l] == 'M') count++;
                    }
                }
                if (count > 0) {
                    board[i][j] = (char) (count + '0');
                } else {
                    board[i][j] = 'B';
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            if (k == 0 && l == 0) continue;
                            int x = k + i, y = l + j;
                            if (x < 0 || x >= m || y < 0 || y >= n) continue;
                            if (board[x][y] == 'E') {
                                queue.add(new int[]{x, y});
                                board[x][y] = 'B';
                            }
                        }
                    }
                }
            }
        }
        return board;
    }
}
