package company.fbr5.q0;

public class Q50 {
    public double myPow(double x, int n) {
        long N = (long) n;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        double cur = x, res = 1;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 != 0) {
                res *= cur;
            }
            cur *= cur;
        }
        return res;
    }

    private double helper(double x, long n) {
        if (n == 0) return 1;
        if (n % 2 == 0) {
            return helper(x * x, n / 2);
        } else {
            return x * helper(x * x, n / 2);
        }
    }
}
