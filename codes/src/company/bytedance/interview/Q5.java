package company.bytedance.interview;

/*
Given a positive integer n, generate an n x n matrix
filled with elements from 1 to n2 in spiral order.
 */
public class Q5 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int startRow = 0, startCol = 0;
        int endRow = n - 1, endCol = n - 1;
        int num = 1;
        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                res[startRow][i] = num++;
            }
            startRow++;
            for (int i = startRow; i <= endRow; i++) {
                res[i][endCol] = num++;
            }
            endCol--;
            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    res[endRow][i] = num++;
                }
                endRow--;
            }
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    res[i][startCol] = num++;
                }
                startCol++;
            }
        }
        return res;
    }
}
