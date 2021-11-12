package company.fbr4.q400;

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
        int num = start + (n - 1) / len;
        String s = String.valueOf(num);
        return s.charAt((n - 1) % len) - '0';
    }
}
