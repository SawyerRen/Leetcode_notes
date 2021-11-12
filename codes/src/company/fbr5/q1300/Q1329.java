package company.fbr5.q1300;

import java.util.*;

public class Q1329 {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                map.putIfAbsent(key, new LinkedList<>());
                map.get(key).add(mat[i][j]);
            }
        }
        for (Integer key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                mat[i][j] = map.get(key).removeFirst();
            }
        }
        return mat;
    }
}
