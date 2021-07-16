package topics.math;

public class Q264 {
    public int nthUglyNumber(int n) {
        int index1 = 1, index2 = 1, index3 = 1;
        int factor1 = 2, factor2 = 3, factor3 = 5;
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Math.min(factor1, Math.min(factor2, factor3));
            ugly[i] = min;
            if (min == factor1) {
                factor1 = 2 * ugly[index1++];
            }
            if (min == factor2) {
                factor2 = 3 * ugly[index2++];
            }
            if (min == factor3) {
                factor3 = 5 * ugly[index3++];
            }
        }
        return ugly[n - 1];
    }
}
