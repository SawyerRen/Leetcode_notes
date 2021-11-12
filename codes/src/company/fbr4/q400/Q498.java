package company.fbr4.q400;

public class Q498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int row = 0, col = 0, d = 0;
        int[][] dirs = {{-1, 1}, {1, -1}};
        for (int i = 0; i < res.length; i++) {
            res[i] = mat[row][col];
            row += dirs[d][0];
            col += dirs[d][1];
            if (row >= m) {
                row = m - 1;
                col += 2;
                d = 1 - d;
            } else if (col >= n) {
                col = n - 1;
                row += 2;
                d = 1 - d;
            } else if (row < 0) {
                row = 0;
                d = 1 - d;
            } else if (col < 0) {
                col = 0;
                d = 1 - d;
            }
        }
        return res;
    }
}
