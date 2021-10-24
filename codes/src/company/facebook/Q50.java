package company.facebook;

public class Q50 {
    // logN     logN
    public double myPow(double x, int n) {
        long num = (long) n;
        if (num < 0) {
            x = 1 / x;
            num = -num;
        }
        return helper(x, num);
    }

    private double helper(double x, long num) {
        if (num == 0) return 1;
        if (num % 2 == 0) {
            return helper(x * x, num / 2);
        } else {
            return x * helper(x * x, num / 2);
        }
    }
}
