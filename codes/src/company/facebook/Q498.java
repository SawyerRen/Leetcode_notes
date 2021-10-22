package company.facebook;

public class Q498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int[][] dirs = {{-1, 1}, {1, -1}};
        int d = 0;
        int i = 0, j = 0;
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        for (int k = 0; k < res.length; k++) {
            res[k] = mat[i][j];
            i += dirs[d][0];
            j += dirs[d][1];

            if (i >= m) {
                i = m - 1;
                j += 2;
                d = 1 - d;
            }
            if (j >= n) {
                j = n - 1;
                i += 2;
                d = 1 - d;
            }
            if (i < 0) {
                i = 0;
                d = 1 - d;
            }
            if (j < 0) {
                j = 0;
                d = 1 - d;
            }
        }
        return res;
    }
}
