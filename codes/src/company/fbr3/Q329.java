package company.fbr3;

public class Q329 {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, helper(memo, matrix, i, j, m, n));
            }
        }
        return res;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private int helper(int[][] memo, int[][] matrix, int i, int j, int m, int n) {
        if (memo[i][j] != 0) return memo[i][j];
        int res = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) continue;
            if (matrix[x][y] <= matrix[i][j]) continue;
            res = Math.max(res, helper(memo, matrix, x, y, m, n) + 1);
        }
        memo[i][j] = res;
        return res;
    }
}
