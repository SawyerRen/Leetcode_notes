package all_solution;

public class Q7 {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            int tail = x % 10;
            res = res * 10 + tail;
            if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return 0;
            x /= 10;
        }
        return (int) res;
    }
}
