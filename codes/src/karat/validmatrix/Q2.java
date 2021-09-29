package karat.validmatrix;

import java.util.ArrayList;
import java.util.List;

public class Q2 {
    public static boolean checkNonogram(int[][] matrix, int[][] rows, int[][] cols) {
        return checkRow(matrix, rows) && checkCol(matrix, cols);
    }

    private static boolean checkCol(int[][] matrix, int[][] cols) {
        if (matrix[0].length != cols.length) return false;
        for (int j = 0; j < matrix[0].length; j++) {
            int zeroCount = 0;
            List<Integer> pattern = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == 0) zeroCount++;
                if (matrix[i][j] == 1 && zeroCount != 0) pattern.add(zeroCount);
            }
            if (pattern.size() != cols[j].length) return false;
            if (pattern.size() == 0) continue;
            for (int k = 0; k < pattern.size(); k++) {
                if (pattern.get(k) != cols[j][k]) return false;
            }
        }
        return true;
    }

    private static boolean checkRow(int[][] matrix, int[][] rows) {
        if (matrix.length != rows.length) return false;
        for (int i = 0; i < matrix.length; i++) {
            int zeroCount = 0;
            List<Integer> pattern = new ArrayList<>();
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) zeroCount++;
                if (matrix[i][j] == 1 && zeroCount != 0) {
                    pattern.add(zeroCount);
                }
            }
            if (pattern.size() != rows[i].length) return false;
            if (pattern.size() == 0) continue;
            for (int k = 0; k < pattern.size(); k++) {
                if (pattern.get(k) != rows[i][k]) return false;
            }
        }
        return true;
    }
}
