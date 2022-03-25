package all_solution.q900;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q997 {
    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n + 1];
        int[] trusted = new int[n + 1];
        for (int[] t : trust) {
            trusts[t[1]]++;
            trusted[t[0]]++;
        }
        for (int i = 1; i < n + 1; i++) {
            if (trusted[i] == 0 && trusts[i] == n - 1) return i;
        }
        return -1;
    }
}
