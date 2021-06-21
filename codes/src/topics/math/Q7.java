package topics.math;

public class Q7 {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            int tail = x % 10;
            res = res * 10 + tail;
            x /= 10;
            if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
                res = 0;
            }
        }
        return (int) res;
    }
}
