package all_solution.q200;

public class Q289 {
    int DEAD = 0;
    int LIVE = 1;
    int DEAD2LIVE = 2;
    int LIVE2DEAD = 3;

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = getCount(board, i, j, m, n);
                if (board[i][j] == LIVE) {
                    if (count < 2 || count > 3) board[i][j] = LIVE2DEAD;
                } else if (board[i][j] == DEAD && (count == 3)) board[i][j] = DEAD2LIVE;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == LIVE2DEAD) board[i][j] = 0;
                else if (board[i][j] == DEAD2LIVE) board[i][j] = 1;
            }
        }
    }
    private int getCount(int[][] board, int row, int col, int m, int n) {
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
