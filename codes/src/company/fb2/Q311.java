package company.fb2;

import java.util.ArrayList;
import java.util.List;

public class Q311 {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] res = new int[mat1.length][mat2[0].length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                if (mat1[i][j] != 0) {
                    for (int k = 0; k < mat2[0].length; k++) {
                        if (mat2[j][k] != 0) {
                            res[i][k] += mat1[i][j] * mat2[j][k];
                        }
                    }
                }
            }
        }
        return res;
    }

    public int[][] multiply1(int[][] mat1, int[][] mat2) {
        int[][] res = new int[mat1.length][mat2[0].length];
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                if (mat1[i][j] != 0) list1.add(new int[]{i, j});
            }
        }
        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                if (mat2[i][j] != 0) list2.add(new int[]{i, j});
            }
        }
        for (int[] n1 : list1) {
            for (int[] n2 : list2) {
                if (n1[1] == n2[0]) {
                    res[n1[0]][n2[1]] += mat1[n1[0]][n1[1]] * mat2[n2[0]][n2[1]];
                }
            }
        }
        return res;
    }
}
