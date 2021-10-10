package company.facebook;

import java.util.ArrayList;
import java.util.List;

interface BinaryMatrix {
    public int get(int row, int col);

    public List<Integer> dimensions();
}

public class Q1428 {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        int i = 0, j = col - 1;
        int res = Integer.MAX_VALUE;
        while (i < row && j >= 0) {
            if (binaryMatrix.get(i, j) == 1) {
                res = Math.min(res, j);
                j--;
            } else {
                i++;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
