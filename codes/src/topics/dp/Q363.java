package topics.dp;

import java.util.Map;
import java.util.TreeSet;

public class Q363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < m; r1++) {
            int[] arr = new int[n];
            for (int r2 = r1; r2 < m; r2++) {
                for (int c = 0; c < n; c++) {
                    arr[c] += matrix[r2][c];
                }
                res = Math.max(res, getMaxSum(arr, k));
            }
        }
        return res;
    }

    private int getMaxSum(int[] arr, int target) {
        int n = arr.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + arr[i];
        }
        int res = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n + 1; i++) {
            if (!set.isEmpty()) {
                Integer ceiling = set.ceiling(preSum[i] - target);
                if (ceiling != null) res = Math.max(res, preSum[i] - ceiling);
            }
            set.add(preSum[i]);
        }
        return res;
    }
}
