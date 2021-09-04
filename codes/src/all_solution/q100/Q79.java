package all_solution.q100;

import java.util.Calendar;

public class Q79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (found(board, i, j, word, 0, new boolean[board.length][board[0].length])) return true;
            }
        }
        return false;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private boolean found(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j])
            return false;
        for (int[] dir : dirs) {
            visited[i][j] = true;
            if (found(board, i + dir[0], j + dir[1], word, index + 1, visited)) return true;
            visited[i][j] = false;
        }
        return false;
    }
}
