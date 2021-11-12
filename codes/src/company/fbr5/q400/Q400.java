package company.fbr5.q400;

public class Q400 {
    public int findNthDigit(int n) {
        long start = 1, len = 1, range = 9;
        while (n > range * len) {
            n -= range * len;
            start *= 10;
            len++;
            range *= 10;
        }
        long num = start + (n - 1) / len;
        return String.valueOf(num).charAt((int) ((n - 1) % len)) - '0';
    }
}
