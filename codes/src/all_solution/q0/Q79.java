package all_solution.q0;

public class Q79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, i, j, word, 0, new boolean[m][n])) return true;
            }
        }
        return false;
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean helper(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) return false;
        if (board[i][j] != word.charAt(index)) return false;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            if (helper(board, i + dir[0], j + dir[1], word, index + 1, visited)) return true;
        }
        visited[i][j] = false;
        return false;
    }
}
