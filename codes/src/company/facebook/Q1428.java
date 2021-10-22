package company.facebook;

import java.util.ArrayList;
import java.util.List;

interface BinaryMatrix {
    public int get(int row, int col);

    public List<Integer> dimensions();
}

public class Q1428 {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int m = binaryMatrix.dimensions().get(0);
        int n = binaryMatrix.dimensions().get(1);
        int res = n;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            while (j >= 0 && binaryMatrix.get(i, j) == 1) j--;
            res = Math.min(res, j + 1);
            i++;
        }
        return res == n ? -1 : res;
    }
}
