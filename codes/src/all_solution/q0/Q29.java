package all_solution.q0;

public class Q29 {
    public int divide(int dividend, int divisor) {
        boolean negative = false;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) negative = true;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long res = 0;
        while (absDivisor <= absDividend) {
            long temp = absDivisor;
            long count = 1;
            while (temp <= absDividend) {
                temp <<= 1;
                count <<= 1;
            }
            res += count >> 1;
            if (res > Integer.MAX_VALUE) {
                if (negative) return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            absDividend -= temp >> 1;
        }
        return negative ? -(int) res : (int) res;
    }
}
