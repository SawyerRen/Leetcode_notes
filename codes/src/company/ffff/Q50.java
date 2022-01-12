package company.ffff;

public class Q50 {
    public double myPow(double x, int n) {
        long N = (long) n;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        double res = 1;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                res *= x;
            }
            x *= x;
        }
        return res;
    }
}
