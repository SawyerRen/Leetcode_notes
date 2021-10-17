package company.facebook;

public class Q329 {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j, m, n, memo));
            }
        }
        return res;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] memo) {
        if (memo[i][j] != 0) return memo[i][j];
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[i][j] >= matrix[x][y]) continue;
            int len = 1 + dfs(matrix, x, y, m, n, memo);
            max = Math.max(max, len);
        }
        memo[i][j] = max;
        return max;
    }
}
