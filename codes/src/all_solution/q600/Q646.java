package all_solution.q600;

import java.util.Arrays;
import java.util.Comparator;

public class Q646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int res = 1;
        int curEnd = pairs[0][1];
        for (int[] pair : pairs) {
            if (pair[0] > curEnd) {
                curEnd = pair[1];
                res++;
            }
        }
        return res;
    }
}
