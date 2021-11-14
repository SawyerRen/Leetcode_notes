package company.fbr5.again;

public class Q400 {
    public int findNthDigit(int n) {
        long start = 1, range = 9;
        int len = 1;
        while (n > len * range) {
            n -= len * range;
            start *= 10;
            range *= 10;
            len++;
        }
        start = start + (n - 1) / len;
        return String.valueOf(start).charAt((n - 1) % len) - '0';
    }
}
