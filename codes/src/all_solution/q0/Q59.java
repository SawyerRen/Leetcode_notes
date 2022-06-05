package all_solution.q0;

public class Q59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, top = 0, down = n - 1;
        int num = 1;
        while (left <= right && top <= down) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            top++;
            for (int i = top; i <= down; i++) {
                res[i][right] = num++;
            }
            right--;
            if (top <= down) {
                for (int i = right; i >= left; i--) {
                    res[down][i] = num++;
                }
                down--;
            }
            if (left <= right) {
                for (int i = down; i >= top; i--) {
                    res[i][left] = num++;
                }
                left++;
            }
        }
        return res;
    }
}
