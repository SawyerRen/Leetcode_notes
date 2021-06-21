package topics.array;

import java.util.ArrayList;
import java.util.List;

public class Q54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int upRow = 0, downRow = matrix.length - 1;
        int leftCol = 0, rightCol = matrix[0].length - 1;
        while (upRow <= downRow && leftCol <= rightCol) {
            for (int j = leftCol; j <= rightCol; j++) {
                res.add(matrix[upRow][j]);
            }
            upRow++;
            for (int i = upRow; i <= downRow; i++) {
                res.add(matrix[i][rightCol]);
            }
            rightCol--;
            if (upRow <= downRow) {
                for (int j = rightCol; j >= leftCol; j--) {
                    res.add(matrix[downRow][j]);
                }
                downRow--;
            }
            if (leftCol <= rightCol) {
                for (int i = downRow; i >= upRow; i--) {
                    res.add(matrix[i][leftCol]);
                }
                leftCol++;
            }
        }
        return res;
    }
}
