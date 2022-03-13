package all_solution.q500;

import java.util.LinkedList;
import java.util.Queue;

public class Q529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];
            if (board[x][y] == 'M') {
                board[x][y] = 'X';
                continue;
            }
            int count = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
                    int row = x + i, col = y + j;
                    if (row < 0 || row >= m || col < 0 || col >= n) continue;
                    if (board[row][col] == 'X' || board[row][col] == 'M') count++;
                }
            }
            if (count > 0) {
                board[x][y] = (char) (count + '0');
                continue;
            }
            board[x][y] = 'B';
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
                    int row = x + i, col = y + j;
                    if (row < 0 || row >= m || col < 0 || col >= n) continue;
                    if (board[row][col] == 'E') {
                        queue.add(new int[]{row, col});
                        board[row][col] = 'B';
                    }
                }
            }
        }
        return board;
    }
}
