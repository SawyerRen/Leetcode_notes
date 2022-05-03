package all_solution.q1400;

import java.util.Arrays;

public class Q1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        int maxW = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 0; i < horizontalCuts.length - 1; i++) {
            maxH = Math.max(maxH, horizontalCuts[i + 1] - horizontalCuts[i]);
        }
        for (int i = 0; i < verticalCuts.length - 1; i++) {
            maxW = Math.max(maxW, verticalCuts[i + 1] - verticalCuts[i]);
        }
        int mod = (int) (1e9 + 7);
        return (int)((long)maxH * maxW % mod);
    }
}
