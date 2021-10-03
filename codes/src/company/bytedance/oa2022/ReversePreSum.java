package company.bytedance.oa2022;

import java.util.Arrays;

public class ReversePreSum {
   static int[][] solution(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) res[i][j] = matrix[i][j];
                else if (i == 0) res[i][j] = matrix[i][j] - matrix[i][j - 1];
                else if (j == 0) res[i][j] = matrix[i][j] - matrix[i - 1][j];
                else {
                    res[i][j] = matrix[i][j] + matrix[i - 1][j - 1] - matrix[i - 1][j] - matrix[i][j - 1];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 7}};
        int[][] res = solution(mat);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}

