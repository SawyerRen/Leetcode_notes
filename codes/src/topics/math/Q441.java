package topics.math;

public class Q441 {
    public int arrangeCoins(int n) {
        int i = 0;
        while (n > 0) {
            i++;
            n -= i;
        }
        if (n == 0) return i;
        return i - 1;
    }
}
