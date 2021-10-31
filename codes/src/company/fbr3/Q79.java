package company.fbr3;

public class Q79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, word, i, j, m, n, new boolean[m][n], 0)) return true;
            }
        }
        return false;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private boolean helper(char[][] board, String word, int i, int j, int m, int n, boolean[][] visited, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(index)) return false;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            if (helper(board, word, i + dir[0], j + dir[1], m, n, visited, index + 1)) return true;
        }
        visited[i][j] = false;
        return false;
    }
}
