package topics.array;

public class Q59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        int leftCol = 0, rightCol = n - 1;
        int upRow = 0, downRow = n - 1;
        while (leftCol <= rightCol && upRow <= downRow) {
            for (int j = leftCol; j <= rightCol; j++) {
                res[upRow][j] = num++;
            }
            upRow++;
            for (int i = upRow; i <= downRow; i++) {
                res[i][rightCol] = num++;
            }
            rightCol--;
            if (upRow <= downRow) {
                for (int j = rightCol; j >= leftCol; j--) {
                    res[downRow][j] = num++;
                }
                downRow--;
            }
            if (leftCol <= rightCol) {
                for (int i = downRow; i >= upRow; i--) {
                    res[i][leftCol] = num++;
                }
                leftCol++;
            }
        }
        return res;
    }
}
