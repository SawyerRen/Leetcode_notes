package company.fbr4.p0;

import java.util.ArrayList;
import java.util.List;

public class Q54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int startRow = 0, endRow = matrix.length - 1;
        int startCol = 0, endCol = matrix[0].length - 1;
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
                for (int j = endRow; j >= startRow; j--) {
                    res.add(matrix[j][startCol]);
                }
                startCol++;
            }
        }
        return res;
    }
}
