package company.fbr5.q0;

import java.util.ArrayList;
import java.util.List;

public class Q54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int startRow = 0, startCol = 0, endRow = m - 1, endCol = n - 1;
        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                res.add(matrix[startRow][i]);
            }
            startRow++;
            for (int i = startRow; i <= endRow; i++) {
                res.add(matrix[i][endCol]);
            }
            endCol--;
            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    res.add(matrix[endRow][i]);
                }
                endRow--;
            }
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    res.add(matrix[i][startCol]);
                }
                startCol++;
            }
        }
        return res;
    }
}
