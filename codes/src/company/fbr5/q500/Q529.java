package company.fbr5.q500;

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
            int row = poll[0], col = poll[1];
            if (board[row][col] == 'M') {
                board[row][col] = 'X';
            } else {
                int count = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) continue;
                        int x = poll[0] + i, y = poll[1] + j;
                        if (x < 0 || x >= m || y < 0 || y >= n) continue;
                        if (board[x][y] == 'M' || board[x][y] == 'X') count++;
                    }
                }
                if (count > 0) {
                    board[row][col] = (char) (count + '0');
                } else {
                    board[row][col] = 'B';
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (i == 0 && j == 0) continue;
                            int x = poll[0] + i, y = poll[1] + j;
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
