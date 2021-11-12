package company.fbr5.q700;

public class Q723 {
    public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean todo = false;
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n; j++) {
                int val = Math.abs(board[i][j]);
                if (val > 0 && Math.abs(board[i + 1][j]) == val && Math.abs(board[i + 2][j]) == val) {
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -val;
                    todo = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 2; j++) {
                int val = Math.abs(board[i][j]);
                if (val > 0 && Math.abs(board[i][j + 1]) == val && Math.abs(board[i][j + 2]) == val) {
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -val;
                    todo = true;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int row = m - 1;
            for (int i = m - 1; i >= 0; i--) {
                if (board[i][j] > 0) board[row--][j] = board[i][j];
            }
            for (int i = row; i >= 0; i--) {
                board[i][j] = 0;
            }
        }
        if (todo) return candyCrush(board);
        return board;
    }
}
