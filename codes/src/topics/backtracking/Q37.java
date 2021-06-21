package topics.backtracking;

public class Q37 {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    private boolean helper(char[][] board, int i, int j) {
        if (i >= board.length) return true;
        int nextRow = j == board.length - 1 ? i + 1 : i;
        int nextCol = j == board.length - 1 ? 0 : j + 1;
        if (board[i][j] != '.') return helper(board, nextRow, nextCol);
        for (char k = '1'; k <= '9'; k++) {
            if (valid(board, i, j, k)) {
                board[i][j] = k;
                if (helper(board, nextRow, nextCol)) return true;
                board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean valid(char[][] board, int i, int j, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c || board[k][j] == c ||
                    board[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3] == c) return false;
        }
        return true;
    }
}
