package all_solution.q0;

public class Q37 {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    private boolean helper(char[][] board, int row, int col) {
        if (row == board.length) return true;
        int nextRow = col == board.length - 1 ? row + 1 : row;
        int nextCol = col == board.length - 1 ? 0 : col + 1;
        if (board[row][col] != '.') return helper(board, nextRow, nextCol);
        for (char c = '1'; c <= '9'; c++) {
            if (valid(board, row, col, c)) {
                board[row][col] = c;
                if (helper(board, nextRow, nextCol)) return true;
                board[row][col] = '.';
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
