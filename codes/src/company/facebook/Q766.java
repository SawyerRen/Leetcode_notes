package company.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        LinkedList<Integer> list = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int j = 0; j < n; j++) {
            list.add(matrix[0][j]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (list.get(j - 1) != matrix[i][j]) return false;
            }
            list.removeLast();
            list.addFirst(matrix[i][0]);
        }
        return true;
    }

    public boolean isToeplitzMatrix1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) return false;
            }
        }
        return true;
    }
}
