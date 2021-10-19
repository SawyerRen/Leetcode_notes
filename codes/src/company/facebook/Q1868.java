package company.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1868 {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        int i = 0, j = 0;
        List<List<Integer>> res = new ArrayList<>();
        while (i < encoded1.length) {
            int[] en1 = encoded1[i];
            int[] en2 = encoded2[j];
            int len = Math.min(en1[1], en2[1]);
            int mul = en1[0] * en2[0];
            if (res.size() > 0 && res.get(res.size() - 1).get(0) == mul) {
                res.get(res.size() - 1).set(1, res.get(res.size() - 1).get(1) + len);
            } else {
                res.add(Arrays.asList(mul, len));
            }
            en1[1] -= len;
            en2[1] -= len;
            if (en1[1] == 0) i++;
            if (en2[1] == 0) j++;
        }
        return res;
    }
}
