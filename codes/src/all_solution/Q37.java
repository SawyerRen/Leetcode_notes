package all_solution;

public class Q37 {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        if (row == 9) return true;
        int nextRow = col + 1 == 9 ? row + 1 : row;
        int nextCol = col + 1 == 9 ? 0 : col + 1;
        if (board[row][col] != '.') return solve(board, nextRow, nextCol);
        for (char c = '1'; c <= '9'; c++) {
            if (valid(board, row, col, c)) {
                board[row][col] = c;
                if (solve(board, nextRow, nextCol)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    private boolean valid(char[][] board, int row, int col, char c) {
        int regionRow = row / 3 * 3;
        int regionCol = col / 3 * 3;
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c || board[i][col] == c ||
                    board[regionRow + i / 3][regionCol + i % 3] == c) return false;
        }
        return true;
    }
}
