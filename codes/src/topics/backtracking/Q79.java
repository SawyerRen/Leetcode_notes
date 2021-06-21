package topics.backtracking;

public class Q79 {
    int[][] dirs = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        int m = board.length;
        if (m == 0) return false;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, word, i, j, 0, visited)) return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j])
            return false;
        for (int[] dir : dirs) {
            visited[i][j] = true;
            if (helper(board, word, i + dir[0], j + dir[1], index + 1, visited)) return true;
            visited[i][j] = false;
        }
        return false;
    }
}
