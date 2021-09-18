package all_solution.q300;

public class Q378 {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int left = matrix[0][0], right = matrix[m - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = getSmaller(matrix, mid);
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getSmaller(int[][] matrix, int mid) {
        int i = matrix.length - 1, j = 0;
        int count = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > mid) {
                i--;
            } else {
                count += i + 1;
                j++;
            }
        }
        return count;
    }
}
