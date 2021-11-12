package company.fbr5.q0;

public class Q79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, word, 0, i, j, m, n, new boolean[m][n])) return true;
            }
        }
        return false;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private boolean helper(char[][] board, String word, int index, int i, int j, int m, int n, boolean[][] visited) {
        if (index == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index) || visited[i][j]) return false;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            if (helper(board, word, index + 1, i + dir[0], j + dir[1], m, n, visited)) return true;
        }
        visited[i][j] = false;
        return false;
    }
}
