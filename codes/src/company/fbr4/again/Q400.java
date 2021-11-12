package company.fbr4.again;

public class Q400 {
    public int findNthDigit(int n) {
        int start = 1, len = 1;
        long range = 9;
        while (n > len * range) {
            n -= len * range;
            start *= 10;
            len++;
            range *= 10;
        }
        start += (n - 1) / len;
        return String.valueOf(start).charAt((n - 1) % len) - '0';
    }
}
