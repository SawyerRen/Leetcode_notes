package company.codesignal;

import java.util.Arrays;
import java.util.jar.JarEntry;

/*
给一个matrix, 实现clockwise90度旋转，沿main diagonal, second main diagonal
 */
public class ChangeMatrix {
    static void change(int[][] matrix) {
        int n = matrix.length;
        // main diagonal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        // second main diagonal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                swap(matrix, i, j, n - 1 - j, n - 1 - i);
            }
        }
        // clockwise
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                swap(matrix, i, l, i, r);
                l++;
                r--;
            }
        }
    }


    private static void swap(int[][] matrix, int i, int j, int i1, int j1) {
        int t = matrix[i][j];
        matrix[i][j] = matrix[i1][j1];
        matrix[i1][j1] = t;
    }
}
