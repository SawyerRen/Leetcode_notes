package frequency.q300;

public class Q329 {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j, memo, matrix[i][j] - 1));
            }
        }
        return res;
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int dfs(int[][] matrix, int i, int j, int[][] memo, int pre) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= pre)
            return 0;
        if (memo[i][j] != 0) return memo[i][j];
        int res = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];

            res = Math.max(res, dfs(matrix, x, y, memo, matrix[i][j]) + 1);
        }
        memo[i][j] = res;
        return res;
    }
}
