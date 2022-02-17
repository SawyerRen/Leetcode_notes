package all_solution.q200;

public class Q240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            int num = matrix[i][j];
            if (num == target) return true;
            if (num < target) j++;
            else i--;
        }
        return false;
    }
}
