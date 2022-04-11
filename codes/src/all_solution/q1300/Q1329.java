package all_solution.q1300;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q1329 {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int index = i - j;
                map.putIfAbsent(index, new PriorityQueue<>());
                map.get(index).add(mat[i][j]);
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int index = i - j;
                mat[i][j] = map.get(index).poll();
            }
        }
        return mat;
    }
}
