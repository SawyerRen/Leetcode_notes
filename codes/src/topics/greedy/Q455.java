package topics.greedy;

import java.util.Arrays;

public class Q455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int index = 0;
        for (int greed : g) {
            while (index < s.length && s[index] < greed) {
                index++;
            }
            if (index >= s.length) return res;
            res++;
            index++;
        }
        return res;
    }
}
