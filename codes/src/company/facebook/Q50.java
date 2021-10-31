package company.facebook;

public class Q50 {
    // logN     logN
    public double myPow(double x, int n) {
        long N = (long) n;
        if (n < 0) {
            N = -n;
            x = 1 / x;
        }
        return helper(x, N);
    }

    private double helper(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 0) {
            return helper(x * x, n / 2);
        } else {
            return x * helper(x * x, n / 2);
        }
    }

    public double myPow1(double x, int n) {
        long N = (long) n;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double res = 1;
        double cur = x;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 != 0) {
                res *= cur;
            }
            cur *= cur;
        }
        return res;
    }
}
