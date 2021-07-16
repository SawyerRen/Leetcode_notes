package topics.array;

public class Q289 {
    final int LIVE = 1;
    final int DEAD = 0;
    final int LIVE2DEAD = 2;
    final int DEAD2LIVE = 3;

    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countLivingCell(board, i, j);
                if (board[i][j] == LIVE && (count < 2 || count > 3)) board[i][j] = LIVE2DEAD;
                else if (board[i][j] == DEAD && count == 3) board[i][j] = DEAD2LIVE;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == LIVE2DEAD) board[i][j] = DEAD;
                else if (board[i][j] == DEAD2LIVE) board[i][j] = LIVE;
            }
        }
    }

    private int countLivingCell(int[][] board, int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            if (i < 0 || i >= board.length) continue;
            for (int j = col - 1; j <= col + 1; j++) {
                if (j < 0 || j >= board[0].length || i == row && j == col) continue;
                if (board[i][j] == LIVE || board[i][j] == LIVE2DEAD) count++;
            }
        }
        return count;
    }
}
