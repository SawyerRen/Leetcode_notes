package all_solution.q600;

import java.util.Arrays;

public class Q688 {
    int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] memo = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return helper(memo, n, k, row, column);
    }

    private double helper(double[][][] memo, int n, int k, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= n) return 0;
        if (k == 0) return 1;
        if (memo[i][j][k] != -1) return memo[i][j][k];
        double prob = 0;
        for (int[] dir : dirs) {
            prob += helper(memo, n, k - 1, i + dir[0], j + dir[1]) / 8;
        }
        memo[i][j][k] = prob;
        return prob;
    }
}
