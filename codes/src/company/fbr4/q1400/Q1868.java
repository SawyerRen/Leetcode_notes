package company.fbr4.q1400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1868 {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < encoded1.length && j < encoded2.length) {
            int[] en1 = encoded1[i], en2 = encoded2[j];
            int mul = en1[0] * en2[0];
            int minLen = Math.min(en1[1], en2[1]);
            if (res.size() > 0 && res.get(res.size() - 1).get(0) == mul) {
                res.get(res.size() - 1).set(1, res.get(res.size() - 1).get(1) + minLen);
            } else {
                res.add(Arrays.asList(mul, minLen));
            }
            en1[1] -= minLen;
            en2[1] -= minLen;
            if (en1[1] == 0) i++;
            if (en2[1] == 0) j++;
        }
        return res;
    }
}
