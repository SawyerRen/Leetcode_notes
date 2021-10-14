package company.facebook;

public class Q766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int row = i, col = 0;
            int num = matrix[row][col];
            while (row < m && col < n) {
                if (matrix[row][col] != num) return false;
                row++;
                col++;
            }
        }
        for (int i = 1; i < n; i++) {
            int row = 0, col = i;
            int num = matrix[row][col];
            while (row < m && col < n) {
                if (matrix[row][col] != num) return false;
                row++;
                col++;
            }
        }
        return true;
    }
}
