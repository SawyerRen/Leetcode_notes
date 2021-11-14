package company.fbfinal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q766 {
    public boolean isToeplitzMatrix1(int[][] matrix) {
        List<Integer> buff = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int j = 0; j < n; j++) {
            buff.add(matrix[0][j]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != buff.get(j - 1)) return false;
            }
            buff.remove(buff.size() - 1);
            buff.add(0, matrix[i][0]);
        }
        return true;
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) return false;
            }
        }
        return true;
    }
}
