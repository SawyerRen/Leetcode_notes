package company.fbr5.q300;

public class Q329 {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, helper(matrix, memo, i, j, m, n, matrix[i][j]));
            }
        }
        return res;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private int helper(int[][] matrix, int[][] memo, int i, int j, int m, int n, int val) {
        if (memo[i][j] != 0) return memo[i][j];
        int res = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= val) continue;
            res = Math.max(res, helper(matrix, memo, x, y, m, n, matrix[x][y]) + 1);
        }
        memo[i][j] = res;
        return res;
    }
}
