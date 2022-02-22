package all_solution.q200;

public class Q264 {
    public int nthUglyNumber(int n) {
        int f1 = 2, f2 = 3, f3 = 5;
        int index1 = 0, index2 = 0, index3 = 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Math.min(f1, Math.min(f2, f3));
            ugly[i] = min;
            if (min == f1) {
                f1 = 2 * ugly[++index1];
            }
            if (min == f2) {
                f2 = 3 * ugly[++index2];
            }
            if (min == f3) {
                f3 = 5 * ugly[++index3];
            }
        }
        return ugly[n - 1];
    }
}
