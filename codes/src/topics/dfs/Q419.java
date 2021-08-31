package topics.dfs;

public class Q419 {
    public int countBattleships(char[][] board) {
        int m = board.length;
        if (m == 0) return 0;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && !visited[i][j]) {
                    res++;
                    dfs(board, visited, i, j);
                }
            }
        }
        return res;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void dfs(char[][] board, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != 'X') return;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            dfs(board, visited, i + dir[0], j + dir[1]);
        }
    }
}
