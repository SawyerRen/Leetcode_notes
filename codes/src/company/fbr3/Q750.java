package company.fbr3;

public class Q750 {
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
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
