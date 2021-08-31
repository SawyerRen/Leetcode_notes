package all_solution;

public class Q59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        int top = 0, down = n - 1, left = 0, right = n - 1;
        while (top <= down && left <= right) {
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
