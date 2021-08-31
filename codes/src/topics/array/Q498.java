package topics.array;

public class Q498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        if (m == 0) return new int[0];
        int n = mat[0].length;
        int[][] dirs = {{-1, 1}, {1, -1}};
        int[] res = new int[m * n];
        int row = 0, col = 0, d = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = mat[row][col];
            int nextRow = row + dirs[d][0];
            int nextCol = col + dirs[d][1];
            if (nextRow >= m) {
                nextRow = m - 1;
                nextCol += 2;
                d = 1 - d;
            }
            if (nextCol >= n) {
                nextCol = n - 1;
                nextRow += 2;
                d = 1 - d;
            }
            if (nextRow < 0) {
                nextRow = 0;
                d = 1 - d;
            }
            if (nextCol < 0) {
                nextCol = 0;
                d = 1 - d;
            }
            row = nextRow;
            col = nextCol;
        }
        return res;
    }
}
