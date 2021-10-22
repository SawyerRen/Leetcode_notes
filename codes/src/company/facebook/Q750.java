package company.facebook;

public class Q750 {
    public int countCornerRectangles(int[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                int count = 0;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) count++;
                }
                res += count * (count - 1) / 2;
            }
        }
        return res;
    }
}
