package all_solution.q500;

import java.util.Arrays;

public class Q593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] dists = {cal(p1, p2), cal(p1, p3), cal(p1, p4), cal(p2, p3), cal(p2, p4), cal(p3, p4)};
        Arrays.sort(dists);
        return dists[0] > 0 && dists[0] == dists[1] && dists[1] == dists[2] && dists[2] == dists[3] && dists[4] == dists[5];
    }

    int cal(int[] p1, int[] p2) {
        return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }
}
