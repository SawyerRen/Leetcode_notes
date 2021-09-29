package karat.validmatrix;

import java.util.HashSet;
import java.util.Set;

public class Q1 {
    public static boolean validMatrix1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Set<Integer> row = new HashSet<>();
                int n1 = matrix[i][j];
                if (n1 < 1 || n1 > n || !row.add(n1)) return false;
                int n2 = matrix[j][i];
                Set<Integer> col = new HashSet<>();
                if (n2 < 1 || n2 > n || !col.add(n2)) return false;
            }
        }
        return true;
    }
}
