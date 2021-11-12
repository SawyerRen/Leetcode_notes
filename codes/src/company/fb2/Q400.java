package company.fb2;

public class Q400 {
    public int findNthDigit(int n) {
        int len = 1, start = 1;
        long range = 9;
        while (n > len * range) {
            n -= len * range;
            len++;
            range *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String s = String.valueOf(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
