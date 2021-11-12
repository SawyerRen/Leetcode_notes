package company.fbr4.q900;

import java.util.HashMap;
import java.util.Map;

public class Q932 {

    public int[] beautifulArray(int n) {
        int[] res = new int[n];
        if (n == 1) {
            res[0] = 1;
        } else {
            int index = 0;
            int[] odd = beautifulArray((n + 1) / 2);
            for (int val : odd) {
                res[index++] = val * 2 - 1;
            }
            int[] even = beautifulArray(n / 2);
            for (int val : even) {
                res[index++] = val * 2;
            }
        }
        return res;
    }
}
