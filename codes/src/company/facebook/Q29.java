package company.facebook;

public class Q29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean negative = false;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) negative = true;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int res = 0;
        while (divisor <= dividend) {
            res++;
            dividend -= divisor;
        }
        if (negative) return -res;
        return res;
    }
}
