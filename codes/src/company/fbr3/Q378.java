package company.fbr3;

public class Q378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = getSmallerOrEqual(matrix, n, mid);
            if (count >= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private int getSmallerOrEqual(int[][] matrix, int n, int mid) {
        int i = n - 1, j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}
