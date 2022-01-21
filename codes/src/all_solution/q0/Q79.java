package all_solution.q0;

import java.util.Calendar;

public class Q79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, word, m, n, i, j, 0, new boolean[m][n])) return true;
            }
        }
        return false;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private boolean helper(char[][] board, String word, int m, int n, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(index)) return false;
        for (int[] dir : dirs) {
            visited[i][j] = true;
            if (helper(board, word, m, n, i + dir[0], j + dir[1], index + 1, visited)) return true;
            visited[i][j] = false;
        }
        return false;
    }
}
