package all_solution.q100;

public class Q130 {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            helper(board, i, 0);
            helper(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            helper(board, 0, j);
            helper(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void helper(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        board[i][j] = 'T';
        for (int[] dir : dirs) {
            helper(board, i + dir[0], j + dir[1]);
        }
    }
}
