package all_solution.q300;

public class Q329 {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, helper(matrix, memo, i, j, m, n, matrix[i][j] - 1));
            }
        }
        return res;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private int helper(int[][] matrix, int[][] memo, int i, int j, int m, int n, int pre) {
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] <= pre) return 0;
        if (memo[i][j] != 0) return memo[i][j];
        int cur = 1;
        for (int[] dir : dirs) {
            cur = Math.max(cur, 1 + helper(matrix, memo, i + dir[0], j + dir[1], m, n, matrix[i][j]));
        }
        memo[i][j] = cur;
        return cur;
    }
}
