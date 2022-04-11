package all_solution.q1300;

public class Q1326 {
    public int minTaps(int n, int[] ranges) {
        int[] cover = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = i + ranges[i];
            cover[left] = Math.max(cover[left], right);
        }
        int res = 0, curMax = 0, curLen = 0;
        for (int i = 0; i < cover.length; i++) {
            if (curLen >= cover.length - 1) return res;
            curMax = Math.max(curMax, cover[i]);
            if (i == curLen) {
                if (curLen == curMax) return -1;
                curLen = curMax;
                res++;
            }
        }
        return res;
    }
}
