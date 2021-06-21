package topics.array;

import java.util.Arrays;

public class Q73 {
    public void setZeroes(int[][] matrix) {
        boolean firstRowHasZero = false, firstColHasZero = false;
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        // 检查第一行有没有0
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }
        // 把有0的对应的第一行和第一列设为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 根据第一行和第一列的标记设置0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        // 如果第一行和第一列原本有0，则全部设为0
        if (firstRowHasZero) {
            Arrays.fill(matrix[0], 0);
        }
        if (firstColHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
