package company.facebook;

import java.util.ArrayList;
import java.util.List;

interface BinaryMatrix {
    public int get(int row, int col);

    public List<Integer> dimensions();
}

public class Q1428 {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int m = dimensions.get(0), n = dimensions.get(1);
        int i = 0, j = n - 1;
        int res = Integer.MAX_VALUE;
        while (i < m && j >= 0) {
            if (binaryMatrix.get(i, j) == 1) {
                res = Math.min(res, j);
                j--;
            } else {
                i++;
            }
        }
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }
}
