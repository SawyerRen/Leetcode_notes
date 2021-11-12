package company.fbr5.q1000;

public class Q1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] count = new int[1001];
        for (int[] trip : trips) {
            count[trip[1]] += trip[0];
            count[trip[2]] -= trip[0];
        }
        int load = 0;
        for (int i : count) {
            load += i;
            if (load > capacity) return false;
        }
        return true;
    }
}
